package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.AppInfo;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/30
 */
public interface AppInfoService {

    Integer insertAppInfo(AppInfo appInfo);

    Integer deleteAppInfoById(Integer id);

    AppInfo getAppInfoById(Integer id);


    PageInfo<AppInfo> queryAllAppInfo(Integer curronPage, Integer limit);

    Integer updateAppInfo(AppInfo appInfo);


    PageInfo<AppInfo> getAppInfoByNameAndState(String name, Integer state, Integer page, Integer limit);

    List<AppInfo> selectAppInfoList();

}
