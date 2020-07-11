package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.ApiMapper;
import com.qf.web.master.pojo.ApiMapping;
import com.qf.web.master.service.ApiMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@Service
public class ApiMappingSeriviceImpl implements ApiMappingService {

    @Autowired
    private ApiMapper apiMapper;

    //分页展示或搜索
    @Override
    public PageInfo<ApiMapping> selectApiMapping(ApiMapping apiMapping,Integer page,Integer limit) {

        PageHelper.startPage(page,limit);

        List<ApiMapping> apiMappings = apiMapper.selectApiMapping(apiMapping);

        return new PageInfo<>(apiMappings);
    }

    //添加apiMapping
    @Override
    public Integer insertApiMapping(ApiMapping apiMapping) {
        return apiMapper.insertApiMapping(apiMapping);
    }

    //删除api映射
    @Override
    public Integer deleteApiMapping(Integer[] ids) {
        return apiMapper.deleteApiMapping(ids);
    }

    //修改apiMapping
    @Override
    public Integer updateApiMapping(ApiMapping apiMapping) {
        return apiMapper.updateApiMapping(apiMapping);
    }
}
