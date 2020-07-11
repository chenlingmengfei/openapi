package com.qf.web.master.mapper;

import com.qf.web.master.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
public interface CustomerMapper {

    Integer insertCustomer(Customer customer);

    Integer deleteCustomerById(Integer id);

    Customer getCustomerById(Integer id);


    List<Customer> queryAllCustomer();

    Integer updateCustomer(Customer customer);

    List<Customer> getCustomerByNameAndState(@Param("name") String name,@Param("state") Integer state);
}
