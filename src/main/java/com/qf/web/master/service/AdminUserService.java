package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.AdminUser;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
public interface AdminUserService {
    AdminUser getAdminUserByEmail(String email, String password);

    PageInfo<AdminUser> getUserList(AdminUser adminUser,Integer page,Integer limit);

    Integer updataUser(AdminUser user);

    Integer deleteUser(Integer[] ids);

    Integer insertUser(AdminUser user);

    List<AdminUser> selectUserList();

    List<Integer> getUserRoleId(Integer userId);

    void insertUserRole(Integer roleId, List<Integer> menuIds);
}
