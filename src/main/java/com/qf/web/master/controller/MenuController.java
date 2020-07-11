package com.qf.web.master.controller;

import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.AdminUser;
import com.qf.web.master.pojo.Menu;
import com.qf.web.master.service.MenuService;
import com.qf.web.master.utils.CookieUtils;
import com.qf.web.master.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/menuController")
public class MenuController {

    @Autowired
    private MenuService menuService;


    //菜单选项
    @RequestMapping("/menu")
    public AjaxResponse menu(HttpSession httpSession, HttpServletResponse response, HttpServletRequest request) {
        AdminUser adminUser = (AdminUser) httpSession.getAttribute("login_success");
        AdminUser adminUser1 = null;
        try {

            String user = CookieUtils.getCookieValue(request, "user", true);

            System.out.println(user);

            adminUser1 = (AdminUser) MapperUtils.json2pojo(CookieUtils.getCookieValue(request,"user",true),AdminUser.class);
            System.out.println(adminUser1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(adminUser == null && adminUser1 == null){
            try {
                response.sendRedirect("login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Menu> menuList = null;

        if(adminUser != null){
            menuList = menuService.getMenu(adminUser.getId());
        }
        if(adminUser == null && adminUser1 != null){
            menuList = menuService.getMenu(adminUser1.getId());
        }

        return new AjaxResponse(true,"success",menuList);
    }

    //获取所有菜单
    @RequestMapping("/all")
    public List<Menu> allMenu(){
        return menuService.getAllMenuList();
    }

    @RequestMapping("/parentMenu")
    public List<Menu> parentMenu(){
        return menuService.getParentMenu();
    }


    //根据登录用户获取菜单
    @RequestMapping("/menulist")
    public TableData<Menu> menuList(HttpSession httpSession, HttpServletResponse response, HttpServletRequest request) throws IOException {
        AdminUser adminUser = (AdminUser) httpSession.getAttribute("login_success");
        AdminUser adminUser1 = null;
        try {

            String user = CookieUtils.getCookieValue(request, "user", true);

            System.out.println(user);

            adminUser1 = (AdminUser) MapperUtils.json2pojo(CookieUtils.getCookieValue(request,"user",true),AdminUser.class);
            System.out.println(adminUser1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Menu> menuList = null;

        if(adminUser != null){
            menuList = menuService.getMenuList(adminUser.getId());
        }
        if(adminUser == null && adminUser1 != null){
            menuList = menuService.getMenuList(adminUser1.getId());
        }

        TableData<Menu> tableData = new TableData<>();

        tableData.setData(menuList);
        tableData.setMsg("成功");
        return tableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(Menu menu){

        try{
            menuService.insertMenu(menu);
            return new AjaxResponse(true,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"添加失败",null);
        }
    }

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResponse delete(Integer[] ids){
        try{
            for (Integer id : ids) {
                menuService.deleteMenuList(ids);
            }
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }


    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(Menu menu){
        try{
            menuService.updateMenu(menu);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

}
