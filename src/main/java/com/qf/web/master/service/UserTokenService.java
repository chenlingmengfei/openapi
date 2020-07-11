package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.UserToken;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
public interface UserTokenService {

    PageInfo<UserToken> selectUserToken(UserToken userToken, Integer page, Integer limit);

    Integer insertUserToken(UserToken userToken);

    Integer deleteUserToken(Integer[] ids);

    Integer updateUserToken(UserToken userToken);

}
