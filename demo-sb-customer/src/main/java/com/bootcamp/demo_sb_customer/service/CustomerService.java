package com.bootcamp.demo_sb_customer.service;

import java.util.List;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
//import org.springframework.stereotype.Service;
//import com.bootcamp.demo_sb_customer.model.Customer;


public interface CustomerService {
 
    List<CustomerEntity> getCustomers();

    CustomerEntity createCustomer(CustomerEntity customerEntity);

    List<CustomerEntity> getCustomerByJPQL(String customerName);
    
   // CustomerEntity deleteByIdCustomer(Long Id);
   List<CustomerEntity> getCustomerByNQ(String customerName);

    
}
