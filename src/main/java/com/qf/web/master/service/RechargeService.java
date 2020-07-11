package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.Recharge;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
public interface RechargeService {

    PageInfo<Recharge> selectRecharge(Recharge recharge,Integer page,Integer limit);

    Integer insertRecharge(Recharge recharge);

    Integer deleteRecharge(Integer[] ids);

    Integer updateRecharge(Recharge recharge);


}
