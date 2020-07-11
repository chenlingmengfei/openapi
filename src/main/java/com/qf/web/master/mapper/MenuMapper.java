package com.qf.web.master.mapper;

import com.qf.web.master.pojo.Menu;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
public interface MenuMapper {


    List<Menu> getMenuList(Integer id);

    Integer insertMenu(Menu menu);

    Integer updateMenu(Menu menu);

    Integer deleteMenuList(Integer[] ids);

    List<Menu> getAllMenuList();
}
