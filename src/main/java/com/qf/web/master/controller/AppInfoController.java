package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.AppInfo;
import com.qf.web.master.pojo.Customer;
import com.qf.web.master.service.AppInfoService;
import com.qf.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/30
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/appInfoController")
public class AppInfoController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private CustomerService customerService;

    //展示
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public TableData<AppInfo> queryCustomer(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "5") Integer limit){

        TableData<AppInfo> appInfoTableData = new TableData<>();

        PageInfo<AppInfo> appInfoPageInfo = appInfoService.queryAllAppInfo(page, limit);

        appInfoTableData.setCode(0);

        //customerTableData.setMsg("success");

        appInfoTableData.setCount(appInfoPageInfo.getTotal());

        appInfoTableData.setData(appInfoPageInfo.getList());

        return appInfoTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(AppInfo appInfo){

        try{
            Customer customerById = customerService.getCustomerById(appInfo.getCusId());

            appInfo.setCorpName(customerById.getNickname());

            appInfoService.insertAppInfo(appInfo);
            return new AjaxResponse(true,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"添加失败",null);
        }
    }

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResponse delete(Integer[] ids){
        try{
            for (Integer id : ids) {
                appInfoService.deleteAppInfoById(id);
            }
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(AppInfo appInfo){


        try{
            Customer customerById = customerService.getCustomerById(appInfo.getCusId());

            appInfo.setCorpName(customerById.getNickname());

            appInfoService.updateAppInfo(appInfo);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

    //搜索
    @RequestMapping("/search")
    public TableData<AppInfo> search(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer limit,
                                      String name, Integer state){

        TableData<AppInfo> tableData = new TableData<>();
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.getAppInfoByNameAndState(name,state,page,limit);
        tableData.setData(appInfoPageInfo.getList());
        tableData.setCount(appInfoPageInfo.getTotal());

        return tableData;
    }


    //获取所有api数据
    @RequestMapping("/all")
    public List<AppInfo> allAppinfo(){
        return appInfoService.selectAppInfoList();
    }
}
