package com.bootcamp.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity) {
        this.customerService.createCustomer(customerEntity);
        //this.CustomerServiceImpl.createCustomer(customerEntity);
        return customerEntity;

    }

    @Override
    public List<CustomerEntity> getCustomers() {
        //return this.customerServiceImpl.getCustomers();
        return this.customerService.getCustomers();
    }

    
}
