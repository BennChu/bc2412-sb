package com.bootcamp.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.demo_sb_customer.codewave.SysCode;
import com.bootcamp.demo_sb_customer.controller.CustomerOperation;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.service.CustomerService;
//import com.bootcamp.demo_sb_customer.service.impl.CustomerServiceImpl;

@RestController 
// this is class level
// @RestController = @Controller + @ResponeBody
// @Controller, as a web controller capable of handling HTTP requests
// @ResponeBody, Automatically applied to all methods in the class, indicating that 
// the return value of each method should be serialized directly into the HTTP response 
// body (typically as JSON or XML) instead of being resolved as a view
public class CustomerController implements CustomerOperation{
  
    // Autowired 要放 inside class not inside method
    // Autowired 對方個 interface is normal practise
    // so not private CustomerServiceImpl CustomerServiceImpl;
    @Autowired
    private CustomerService customerService;

    // remember need to @Override
    // this method return ApiResp Type
    @Override
    public ApiResp<List<CustomerEntity>> getCustomers() {
        
        List<CustomerEntity> customerEntities = this.customerService.getCustomers();
        return ApiResp.<List<CustomerEntity>>builder()
                .syscode(SysCode.OK) // 可以唔加 ok, 
                // .code("1") can set like this, bcoz have code method
                // .message("Success.")
                .data(customerEntities)
                .build();
    }

    @Override
    public ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {
        //this.customerService.createCustomer(customerEntity);
        //this.CustomerServiceImpl.createCustomer(customerEntity);
        CustomerEntity serviceResult = this.customerService.createCustomer(customerEntity);
        return ApiResp.<CustomerEntity>builder()    // <T>builder is a static method inside ApiResp
                .syscode(SysCode.OK) // 統一 return format
                .data(serviceResult)
                .build();

    }

    @Override
    public List<CustomerEntity> getCustomerByJPQL(@RequestParam String name) {
        return this.customerService.getCustomerByJPQL(name);
    }

    @Override
    public List<CustomerEntity> getCustomerByNQ(@RequestParam String name) {
        return this.customerService.getCustomerByNQ(name);
    }


}
