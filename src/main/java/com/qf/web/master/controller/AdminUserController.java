package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.RoleMenu;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.AdminUser;
import com.qf.web.master.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户操作
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/adminUserController")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;


    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResponse login(String email, String password, HttpSession httpSession){
        AdminUser adminUser = adminUserService.getAdminUserByEmail(email,password);
        if(adminUser == null){
            return new AjaxResponse(false,"用户不存在或密码错误",null);
        }else{
            httpSession.setAttribute("login_success",adminUser);
            return new AjaxResponse(true,"登录成功",adminUser);
        }
    }


    //搜索和展示
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public TableData<AdminUser> queryCustomer(AdminUser adminUser,@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "5") Integer limit){

        TableData<AdminUser> appInfoTableData = new TableData<>();

        PageInfo<AdminUser> appInfoPageInfo = adminUserService.getUserList(adminUser,page,limit);


        appInfoTableData.setCount(appInfoPageInfo.getTotal());

        appInfoTableData.setData(appInfoPageInfo.getList());

        return appInfoTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(AdminUser adminUser){

        try{
            adminUserService.insertUser(adminUser);
            return new AjaxResponse(true,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"添加失败",null);
        }
    }

    //根据用户Id查找所有的role
    @RequestMapping("/allRole")
    public List<Integer> getUserRoleId(Integer userId){
        return adminUserService.getUserRoleId(userId);
    }

    //为用户授权
    @RequestMapping("/authorize")
    public AjaxResponse authorize(@RequestBody RoleMenu roleMenu){
        try{
            adminUserService.insertUserRole(roleMenu.getRoleId(),roleMenu.getMenuIds());
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }


    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResponse delete(Integer[] ids){
        try{
            adminUserService.deleteUser(ids);
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(AdminUser adminUser){


        try{
            adminUserService.updataUser(adminUser);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

    //查询所有的用户信息
    @RequestMapping("/all")
    public List<AdminUser> allUser(){
        return adminUserService.selectUserList();
    }
}
