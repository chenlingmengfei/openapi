package com.qf.web.master.mapper;

import com.qf.web.master.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/30
 */
public interface AppInfoMapper {
    Integer insertAppInfo(AppInfo appInfo);

    Integer deleteAppInfoById(Integer id);

    AppInfo getAppInfoById(Integer id);


    List<AppInfo> queryAllAppInfo();

    Integer updateAppInfo(AppInfo appInfo);

    List<AppInfo> getAppInfoByNameAndState(@Param("name") String name, @Param("state") Integer state);
}
