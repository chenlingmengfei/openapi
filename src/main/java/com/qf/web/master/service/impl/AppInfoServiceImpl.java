package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.AppInfoMapper;
import com.qf.web.master.pojo.AppInfo;
import com.qf.web.master.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/30
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    //添加api信息
    @Override
    public Integer insertAppInfo(AppInfo appInfo) {
        return appInfoMapper.insertAppInfo(appInfo);
    }

    //删除api信息
    @Override
    public Integer deleteAppInfoById(Integer id) {
        return appInfoMapper.deleteAppInfoById(id);
    }

    //根据id获取apinfo
    @Override
    public AppInfo getAppInfoById(Integer id) {
        return appInfoMapper.getAppInfoById(id);
    }

    //展示
    @Override
    public PageInfo<AppInfo> queryAllAppInfo(Integer curronPage, Integer limit) {

        PageHelper.startPage(curronPage,limit);

        List<AppInfo> appInfos = appInfoMapper.queryAllAppInfo();

        return new PageInfo<>(appInfos);
    }

    //修改
    @Override
    public Integer updateAppInfo(AppInfo appInfo) {
        return appInfoMapper.updateAppInfo(appInfo);
    }

    //搜索
    @Override
    public PageInfo<AppInfo> getAppInfoByNameAndState(String name, Integer state, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);

        List<AppInfo> appInfoByNameAndState = appInfoMapper.getAppInfoByNameAndState(name, state);

        return new PageInfo<>(appInfoByNameAndState);
    }

    //获取所有api信息
    @Override
    public List<AppInfo> selectAppInfoList() {
        return appInfoMapper.queryAllAppInfo();
    }
}
