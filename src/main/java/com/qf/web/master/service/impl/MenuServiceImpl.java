package com.qf.web.master.service.impl;

import com.qf.web.master.mapper.MenuMapper;
import com.qf.web.master.pojo.Menu;
import com.qf.web.master.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> getMenu(Integer id) {
        List<Menu> menuList = menuMapper.getMenuList(id);
        return oprMenu(menuList);
    }

    @Override
    public Integer insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public Integer updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public Integer deleteMenuList(Integer[] ids) {
        return menuMapper.deleteMenuList(ids);
    }

    @Override
    public List<Menu> getMenuList(Integer id) {
        return menuMapper.getMenuList(id);
    }

    @Override
    public List<Menu> getAllMenuList() {
        List<Menu> menus = menuMapper.getAllMenuList();
        List<Menu> firstMenu = new ArrayList<>();
        Map<Integer, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            menuMap.put(menu.getId(), menu);
            if (menu.getParentId() == null) {//一级菜单
                firstMenu.add(menu);
            }
        }
        for (Menu menu : menus) {
            if (menu.getParentId() != null && menuMap.containsKey(menu.getParentId())) {
                menuMap.get(menu.getParentId()).getChildren().add(menu);
            }
        }
        List<Menu> sortMenu = new ArrayList<>();
        makeMenuList(firstMenu, sortMenu);
        return sortMenu;
    }

    @Override
    public List<Menu> getParentMenu() {
        List<Menu> parentMenu = new ArrayList<>();
        for(Menu menu : menuMapper.getAllMenuList()){
            if(menu.getType() != 2){
                parentMenu.add(menu);
            }
        }
        return parentMenu;
    }

    private void makeMenuList(List<Menu> menus, List<Menu> target) {
        for (Menu menu : menus) {
            target.add(menu);
            if (menu.getChildren().size() > 0) {
                makeMenuList(menu.getChildren(), target);
            }
        }
    }

    private List<Menu> oprMenu(List<Menu> menuList) {

        List<Menu> dataMenu = new ArrayList<>();

        Map<Integer,Menu> pattenMenu = new HashMap<>();

        for (Menu menu : menuList) {
            if(null == menu.getParentId() ){
                dataMenu.add(menu);
                pattenMenu.put(menu.getId(),menu);
            }
        }
        for (Menu menu : menuList) {
            if(menu.getType()!=2 && menu.getType()!=0 && menu.getParentId()!=null){
                if(pattenMenu.containsKey(menu.getParentId())){
                    pattenMenu.get(menu.getParentId()).getChildren().add(menu);
                }
            }
        }
        return dataMenu;
    }


    private List<Menu> allMenu(List<Menu> menuList){
        List<Menu> dataMenu = new ArrayList<>();

        Map<Integer,Menu> pattenMenu = new HashMap<>();

        for (Menu menu : menuList) {
            if(null == menu.getParentId() ){
                dataMenu.add(menu);
                pattenMenu.put(menu.getId(),menu);
            }
        }
        for (Menu menu : menuList) {
            if(menu.getType()!=2 && menu.getType()!=0 && menu.getParentId()!=null){
                if(pattenMenu.containsKey(menu.getParentId())){
                    pattenMenu.get(menu.getParentId()).getChildren().add(menu);
                    pattenMenu.put(menu.getId(),menu);
                }
            }
            if(menu.getType() == 2){
                if(pattenMenu.containsKey(menu.getParentId())){
                    pattenMenu.get(menu.getParentId()).getChildren().add(menu);
                }
            }


        }
        return dataMenu;
    }

}
