package com.qf.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.web.master.mapper.CustomerMapper;
import com.qf.web.master.pojo.Customer;
import com.qf.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Integer insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public Integer deleteCustomerById(Integer id) {
        return customerMapper.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCutomer() {
        return customerMapper.queryAllCustomer();
    }

    @Override
    public PageInfo<Customer> queryAllCustomer(Integer curronPage, Integer limit) {

        PageHelper.startPage(curronPage,limit);

        List<Customer> customers = customerMapper.queryAllCustomer();

        return new PageInfo<>(customers);
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public PageInfo<Customer> getCustomerByNameAndState(String name, Integer state, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);

        List<Customer> customers = customerMapper.getCustomerByNameAndState(name,state);

        return new PageInfo<>(customers);
    }
}
