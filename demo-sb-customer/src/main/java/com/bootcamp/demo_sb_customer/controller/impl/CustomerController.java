package com.bootcamp.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.demo_sb_customer.codewave.SysCode;
import com.bootcamp.demo_sb_customer.controller.CustomerOperation;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.service.CustomerService;
//import com.bootcamp.demo_sb_customer.service.impl.CustomerServiceImpl;

@RestController
public class CustomerController implements CustomerOperation{
  
    @Autowired
    private CustomerService customerService;

    // @Autowired
    // private CustomerServiceImpl CustomerServiceImpl;

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
    public ApiResp<List<CustomerEntity>> getCustomers() {
        //return this.customerServiceImpl.getCustomers();

        List<CustomerEntity> customerEntities = this.customerService.getCustomers();
        return ApiResp.<List<CustomerEntity>>builder()
                //.syscode(SysCode.OK) 可以唔加 ok, 
                .data(customerEntities)
                .build();
    }

    
}
