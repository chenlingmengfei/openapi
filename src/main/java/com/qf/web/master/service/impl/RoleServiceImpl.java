package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.RoleMapper;
import com.qf.web.master.pojo.Role;
import com.qf.web.master.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> slectRoleList(Role role,Integer page,Integer limit) {

        PageHelper.startPage(page,limit);

        List<Role> roles = roleMapper.slectRoleList(role);

        return new PageInfo<>(roles);
    }

    @Override
    public Integer insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public Integer updataRole(Role role) {
        return roleMapper.updataRole(role);
    }

    @Override
    public List<Integer> getMenuAllId(Integer roleId) {
        return roleMapper.getRoleMenuByRoleId(roleId);
    }

    @Override
    public Integer insertRoleMenu(Integer roleId, List<Integer> menuIds) {
        roleMapper.deleteMenuByRoleId(roleId);
        return roleMapper.insertRoleMenu(roleId,menuIds);
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.slectRoleList(new Role());
    }
}
