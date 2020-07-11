package com.qf.web.master.mapper;

import com.qf.web.master.pojo.ApiSystemparam;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface ApiSystemParamMapper {

    List<ApiSystemparam> selectApiSystemparam(ApiSystemparam apiSystemparam);

    Integer insertApiSystemparam(ApiSystemparam apiSystemparam);

    Integer deleteApiSystemparam(Integer[] ids);

    Integer updateApiSystemparam(ApiSystemparam apiSystemparam);

}
