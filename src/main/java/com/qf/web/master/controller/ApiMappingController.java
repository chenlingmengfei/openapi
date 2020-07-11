package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.ApiMapping;
import com.qf.web.master.service.ApiMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/apiMappingController")
public class ApiMappingController {

    @Autowired
    private ApiMappingService apiMappingService;

    //api映射
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public TableData<ApiMapping> queryCustomer(ApiMapping apiMapping, @RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "5") Integer limit){

        TableData<ApiMapping> appInfoTableData = new TableData<>();

        PageInfo<ApiMapping> appInfoPageInfo = apiMappingService.selectApiMapping(apiMapping,page,limit);

        appInfoTableData.setCode(0);

        //customerTableData.setMsg("success");

        appInfoTableData.setCount(appInfoPageInfo.getTotal());

        appInfoTableData.setData(appInfoPageInfo.getList());

        return appInfoTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(ApiMapping apiMapping){

        try{
            apiMappingService.insertApiMapping(apiMapping);
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
            apiMappingService.deleteApiMapping(ids);
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(ApiMapping apiMapping){


        try{
            apiMappingService.updateApiMapping(apiMapping);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

}
