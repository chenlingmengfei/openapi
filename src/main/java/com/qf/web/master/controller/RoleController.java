package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.RoleMenu;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.Role;
import com.qf.web.master.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/roleController")
public class RoleController {


    @Autowired
    private RoleService roleService;

    //展示和搜索相结合
    @RequestMapping("/table")
    public TableData<Role> table(Role role, @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer limit){

        PageInfo<Role> rolePageInfo = roleService.slectRoleList(role, page, limit);

        TableData<Role> roleTableData = new TableData<>();

        roleTableData.setCount(rolePageInfo.getTotal());
        roleTableData.setData(rolePageInfo.getList());

        return roleTableData;
    }

    //根据roleId获取菜单id
    @RequestMapping("/allMenuId")
    public List<Integer> allMenuId(Integer roleId){
        return roleService.getMenuAllId(roleId);
    }

    @RequestMapping("/allRole")
    public List<Role> allRole(){
        return roleService.getAllRole();
    }

    //授权
    @RequestMapping(value = "/authorize",method = RequestMethod.POST)
    public AjaxResponse authorize(@RequestBody RoleMenu roleMenu){
        try{
            roleService.insertRoleMenu(roleMenu.getRoleId(),roleMenu.getMenuIds());
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }


    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(Role role){

        try{
            roleService.insertRole(role);
            return new AjaxResponse(true,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"添加失败",null);
        }
    }


    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(Role role){
        try{
            roleService.updataRole(role);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

}
