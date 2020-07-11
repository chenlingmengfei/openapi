package com.qf.web.master.mapper;

import com.qf.web.master.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
public interface AdminUserMapper {

    AdminUser selectAdminUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);

    Integer insertUser(AdminUser adminUser);

    Integer deleteUser(Integer[] ids);

    Integer updateUser(AdminUser adminUser);

    List<AdminUser> selectUserList(AdminUser adminUser);

    List<Integer> selectUserRoleId(Integer userId);

    void deleteUserRole(Integer userId);

    void insertUserRole(@Param("userId") Integer userId,@Param("role") Integer role);
}
