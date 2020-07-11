package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.Role;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface RoleService {

    PageInfo<Role> slectRoleList(Role role,Integer page,Integer limit);


    Integer insertRole(Role role);

    Integer updataRole(Role role);

    List<Integer> getMenuAllId(Integer roleId);

    Integer insertRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Role> getAllRole();
}
