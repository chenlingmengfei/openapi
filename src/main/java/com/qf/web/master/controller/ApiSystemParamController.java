package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.ApiSystemparam;
import com.qf.web.master.service.ApiSystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/2
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/apiSystemParamController")
public class ApiSystemParamController {

    @Autowired
    private ApiSystemParamService apiSystemParamService;

    //展示和查询相结合
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public TableData<ApiSystemparam> queryCustomer(ApiSystemparam apiSystemparam, @RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "5") Integer limit){

        TableData<ApiSystemparam> appInfoTableData = new TableData<>();

        PageInfo<ApiSystemparam> appInfoPageInfo = apiSystemParamService.selectApiSystemparam(apiSystemparam,page,limit);

        appInfoTableData.setCode(0);

        //customerTableData.setMsg("success");

        appInfoTableData.setCount(appInfoPageInfo.getTotal());

        appInfoTableData.setData(appInfoPageInfo.getList());

        return appInfoTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(ApiSystemparam apiSystemparam){

        try{
            apiSystemParamService.insertApiSystemparam(apiSystemparam);
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
            apiSystemParamService.deleteApiSystemparam(ids);
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(ApiSystemparam apiSystemparam){


        try{
            apiSystemParamService.updateApiSystemparam(apiSystemparam);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

}
