package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.ApiSystemparam;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface ApiSystemParamService {

    PageInfo<ApiSystemparam> selectApiSystemparam(ApiSystemparam apiSystemparam, Integer page, Integer limit);

    Integer insertApiSystemparam(ApiSystemparam apiSystemparam);

    Integer deleteApiSystemparam(Integer[] ids);

    Integer updateApiSystemparam(ApiSystemparam apiSystemparam);

}
