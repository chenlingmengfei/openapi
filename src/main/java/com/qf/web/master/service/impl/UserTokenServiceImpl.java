package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.TokenMapper;
import com.qf.web.master.pojo.UserToken;
import com.qf.web.master.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public PageInfo<UserToken> selectUserToken(UserToken userToken, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);

        List<UserToken> userTokens = tokenMapper.selectUserToken(userToken);

        return new PageInfo<>(userTokens);
    }

    @Override
    public Integer insertUserToken(UserToken userToken) {
        return tokenMapper.insertUserToken(userToken);
    }

    @Override
    public Integer deleteUserToken(Integer[] ids) {
        return tokenMapper.deleteUserToken(ids);
    }

    @Override
    public Integer updateUserToken(UserToken userToken) {
        return tokenMapper.updateUserToken(userToken);
    }
}
