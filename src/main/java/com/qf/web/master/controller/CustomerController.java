package com.qf.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.qf.web.master.bean.AjaxResponse;
import com.qf.web.master.bean.TableData;
import com.qf.web.master.pojo.Customer;
import com.qf.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CL
 * @version 1.0
 * @date: 2020/6/29
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/customerController")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //展示
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public TableData<Customer> queryCustomer(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "5") Integer limit, HttpServletRequest request){


        TableData<Customer> customerTableData = new TableData<>();

        PageInfo<Customer> customerPageInfo = customerService.queryAllCustomer(page, limit);

        customerTableData.setCode(0);

        //customerTableData.setMsg("success");

        customerTableData.setCount(customerPageInfo.getTotal());

        customerTableData.setData(customerPageInfo.getList());

        return customerTableData;
    }

    //添加
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResponse add(Customer customer){

        try{
            customerService.insertCustomer(customer);
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
            for (Integer id : ids) {
                customerService.deleteCustomerById(id);
            }
            return new AjaxResponse(true,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"删除失败",null);
        }
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResponse update(Customer customer){

        try{
            customerService.updateCustomer(customer);
            return new AjaxResponse(true,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResponse(false,"修改失败",null);
        }
    }

    //搜索
    @RequestMapping("/search")
    public TableData<Customer> search(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "5") Integer limit,
                                      String name,Integer state){

        TableData<Customer> tableData = new TableData<>();
        PageInfo<Customer> customerPageInfo = customerService.getCustomerByNameAndState(name,state,page,limit);
        tableData.setData(customerPageInfo.getList());
        tableData.setCount(customerPageInfo.getTotal());

        return tableData;
    }

    //获取所有的客户信息
    @RequestMapping("/all")
    public List<Customer> getAll(){
        return customerService.getAllCutomer();
    }

}
