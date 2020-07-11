package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.RechargeMapper;
import com.qf.web.master.pojo.Recharge;
import com.qf.web.master.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/7/3
 */
@Service
public class RechargeServiceImpl implements RechargeService {


    @Autowired
    private RechargeMapper rechargeMapper;


    @Override
    public PageInfo<Recharge> selectRecharge(Recharge recharge, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);

        List<Recharge> recharges = rechargeMapper.selectRecharge(recharge);


        return new PageInfo<>(recharges);
    }

    @Override
    public Integer insertRecharge(Recharge recharge) {
        return rechargeMapper.insertRecharge(recharge);
    }

    @Override
    public Integer deleteRecharge(Integer[] ids) {
        return rechargeMapper.deleteRecharge(ids);
    }

    @Override
    public Integer updateRecharge(Recharge recharge) {
        return rechargeMapper.updateRecharge(recharge);
    }
}
