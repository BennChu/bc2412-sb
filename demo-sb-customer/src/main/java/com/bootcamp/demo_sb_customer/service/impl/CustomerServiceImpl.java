package com.bootcamp.demo_sb_customer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
//import com.bootcamp.demo_sb_customer.model.Customer;
import com.bootcamp.demo_sb_customer.repository.CustomerRespository;
import com.bootcamp.demo_sb_customer.service.CustomerService;

@Service // Service bean
public class CustomerServiceImpl implements CustomerService {

    // 自己會做
    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<CustomerEntity> getCustomers() {
        return this.customerRespository.findAll();
    }


    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return this.customerRespository.save(customerEntity);
    }

    // @Override
    // public void deleteByIdCustomer(Long Id) {
    //     return this.customerRespository.deleteById(Id);
    // }

    
}
