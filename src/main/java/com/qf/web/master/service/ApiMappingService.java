package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.ApiMapping;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
public interface ApiMappingService {

    PageInfo<ApiMapping> selectApiMapping(ApiMapping apiMapping,Integer page,Integer limit);

    Integer insertApiMapping(ApiMapping apiMapping);

    Integer deleteApiMapping(Integer[] ids);

    Integer updateApiMapping(ApiMapping apiMapping);


}
