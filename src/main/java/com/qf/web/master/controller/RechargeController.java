package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.Recharge;
import com.qf.web.master.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/rechargeController")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    //展示和搜索相结合
    @RequestMapping("/table")
    public TableData<Recharge> table(Recharge recharge, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit){

        PageInfo<Recharge> rolePageInfo = rechargeService.selectRecharge(recharge,page,limit);

        TableData<Recharge> roleTableData = new TableData<>();

        roleTableData.setCount(rolePageInfo.getTotal());
        roleTableData.setData(rolePageInfo.getList());

        return roleTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(Recharge recharge){

        try{
            Date date = new Date();
            recharge.setCreatetime(date);
            recharge.setOrderId(date.getTime());
            rechargeService.insertRecharge(recharge);
            return new AjaxResponse(true,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"添加失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(Recharge recharge){
        try{
            recharge.setUpdatetime(new Date());
            rechargeService.updateRecharge(recharge);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResponse delete(Integer[] ids){
        try{
            rechargeService.deleteRecharge(ids);
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }


}
