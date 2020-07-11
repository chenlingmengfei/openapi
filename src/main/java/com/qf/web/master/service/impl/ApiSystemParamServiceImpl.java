package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.ApiSystemParamMapper;
import com.qf.web.master.pojo.ApiSystemparam;
import com.qf.web.master.service.ApiSystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@Service
public class ApiSystemParamServiceImpl implements ApiSystemParamService {

    @Autowired
    private ApiSystemParamMapper apiSystemParamMapper;

    //分页展示或搜索
    @Override
    public PageInfo<ApiSystemparam> selectApiSystemparam(ApiSystemparam apiSystemparam, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);

        List<ApiSystemparam> apiSystemparams = apiSystemParamMapper.selectApiSystemparam(apiSystemparam);

        return new PageInfo<>(apiSystemparams);
    }

    //添加apiSystemparam
    @Override
    public Integer insertApiSystemparam(ApiSystemparam apiSystemparam) {
        return apiSystemParamMapper.insertApiSystemparam(apiSystemparam);
    }

    //删除apiSystemParam
    @Override
    public Integer deleteApiSystemparam(Integer[] ids) {
        return apiSystemParamMapper.deleteApiSystemparam(ids);
    }

    //修改apiSystemparam
    @Override
    public Integer updateApiSystemparam(ApiSystemparam apiSystemparam) {
        return apiSystemParamMapper.updateApiSystemparam(apiSystemparam);
    }
}
