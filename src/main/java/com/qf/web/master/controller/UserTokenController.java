package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.UserToken;
import com.qf.web.master.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/userTokenController")
public class UserTokenController {


    @Autowired
    private UserTokenService userTokenService;

    //展示和搜索相结合
    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public TableData<UserToken> queryCustomer(UserToken token, @RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "5") Integer limit){

        TableData<UserToken> appInfoTableData = new TableData<>();

        PageInfo<UserToken> appInfoPageInfo = userTokenService.selectUserToken(token,page,limit);

        //customerTableData.setMsg("success");

        appInfoTableData.setCount(appInfoPageInfo.getTotal());

        appInfoTableData.setData(appInfoPageInfo.getList());

        return appInfoTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(@RequestBody UserToken token){

        try{
            token.setAccessToken(UUID.randomUUID().toString());
            userTokenService.insertUserToken(token);
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
            userTokenService.deleteUserToken(ids);
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(@RequestBody UserToken token){

        try{
            userTokenService.updateUserToken(token);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }


}
