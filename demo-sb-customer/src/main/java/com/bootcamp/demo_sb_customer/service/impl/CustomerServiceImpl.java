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


    // unit test
    // assuem return john and mary
    // 我地 test 緊, 係咪左手交右手
    // test 緊, 係咩野都冇做
    @Override
    public List<CustomerEntity> getCustomers() {
        return this.customerRespository.findAll(); // john 20, mary 40
    }


    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
         
        return this.customerRespository.save(customerEntity);
        
    }

    // @Override
    // public void deleteByIdCustomer(Long Id) {
    //     return this.customerRespository.deleteById(Id);
    // }

    @Override
    public List<CustomerEntity> getCustomerByJPQL(String customerName) {
        return this.customerRespository.findByNameByJPQL(customerName);        
    }

    @Override
    public List<CustomerEntity> getCustomerByNQ(String customerName) {
        return this.customerRespository.findByNameByNativeQuery(customerName);
    }

}
