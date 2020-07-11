package com.qf.web.master.service;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.pojo.Customer;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
public interface CustomerService {

    Integer insertCustomer(Customer customer);

    Integer deleteCustomerById(Integer id);

    Customer getCustomerById(Integer id);

    List<Customer> getAllCutomer();

    PageInfo<Customer> queryAllCustomer(Integer curronPage,Integer limit);

    Integer updateCustomer(Customer customer);


    PageInfo<Customer> getCustomerByNameAndState(String name, Integer state, Integer page, Integer limit);
}
