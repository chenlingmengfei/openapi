package com.qf.web.master.mapper;

import com.qf.web.master.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface RoleMapper {

    List<Role> slectRoleList(Role role);


    Integer insertRole(Role role);

    Integer updataRole(Role role);

    List<Integer> getRoleMenuByRoleId(@Param("roleId") Integer roleId);

    Integer deleteMenuByRoleId(Integer roleId);

    Integer insertRoleMenu(@Param("roleId") Integer roleId,@Param("menuIds") List<Integer> menuIds);
}
