package com.qf.web.master.mapper;

import com.qf.web.master.pojo.Recharge;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
public interface RechargeMapper {

    List<Recharge> selectRecharge(Recharge recharge);

    Integer insertRecharge(Recharge recharge);

    Integer deleteRecharge(Integer[] ids);

    Integer updateRecharge(Recharge recharge);

}
