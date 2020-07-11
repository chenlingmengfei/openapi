package com.qf.web.master.mapper;

import com.qf.web.master.pojo.UserToken;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
public interface TokenMapper {

    List<UserToken> selectUserToken(UserToken userToken);

    Integer insertUserToken(UserToken userToken);

    Integer deleteUserToken(Integer[] ids);

    Integer updateUserToken(UserToken userToken);



}
