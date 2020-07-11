package com.qf.web.master.mapper;

import com.qf.web.master.pojo.ApiMapping;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface ApiMapper {

    List<ApiMapping> selectApiMapping(ApiMapping apiMapping);

    Integer insertApiMapping(ApiMapping apiMapping);

    Integer deleteApiMapping(Integer[] ids);

    Integer updateApiMapping(ApiMapping apiMapping);


}
