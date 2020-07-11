package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.AdminUserMapper;
import com.qf.web.master.pojo.AdminUser;
import com.qf.web.master.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/1
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    private AdminUserMapper adminUserMapper;

    //验证登录信息
    @Override
    public AdminUser getAdminUserByEmail(String email, String password) {

        return adminUserMapper.selectAdminUserByEmailAndPassword(email,password);
    }

    //分页展示或搜索
    @Override
    public PageInfo<AdminUser> getUserList(AdminUser adminUser,Integer page,Integer limit) {

        PageHelper.startPage(page,limit);

        List<AdminUser> adminUsers = adminUserMapper.selectUserList(adminUser);

        return new PageInfo<>(adminUsers);
    }

    //修改
    @Override
    public Integer updataUser(AdminUser user) {
        return adminUserMapper.updateUser(user);
    }

    //删除
    @Override
    public Integer deleteUser(Integer[] ids) {
        for(Integer id : ids){
            adminUserMapper.deleteUserRole(id);
        }
        return adminUserMapper.deleteUser(ids);
    }

    //添加用户
    @Override
    public Integer insertUser(AdminUser user) {
        return adminUserMapper.insertUser(user);
    }

    //获取所有用户充值添加界面使用
    @Override
    public List<AdminUser> selectUserList() {
        return adminUserMapper.selectUserList(new AdminUser());
    }


    //根据用户id获取所有的roleId
    @Override
    public List<Integer> getUserRoleId(Integer userId) {
        return adminUserMapper.selectUserRoleId(userId);
    }

    //授权添加的user_role
    @Override
    public void insertUserRole(Integer userId, List<Integer> roles) {
        adminUserMapper.deleteUserRole(userId);
        if(roles.size() > 0){
            //排序
            roles.sort(Integer::compareTo);
            //只添加第一个
            adminUserMapper.insertUserRole(userId,roles.get(0));
        }
    }
}
