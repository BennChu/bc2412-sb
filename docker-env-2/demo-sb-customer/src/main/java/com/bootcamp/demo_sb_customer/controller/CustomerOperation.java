package com.bootcamp.demo_sb_customer.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo_sb_customer.codewave.ApiResp;
//import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;

public interface CustomerOperation {
    
    //http://localhost:8082/customer
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED) // 201
    ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity); 
    //imiplitly public, no need to write public

    //http://localhost:8082/customers
    @GetMapping(value ="/customers")
    @ResponseStatus(HttpStatus.OK)    // 200
    ApiResp<List<CustomerEntity>> getCustomers();

    // @DeleteMapping(value = "/customer/{customer}")
    // CustomerEntity deleteById(@PathVariable CustomerEntity customerEntity, @RequestParam Long Id);

    // http://localhost:8082/jpql/customers?name=
    // 由 customers 開始加 ?, each Param 加 &
    @GetMapping(value = "/jpql/customers")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerEntity> getCustomerByJPQL(@RequestParam String name);

    // http://localhost:8082/nq/customers?name=
    @GetMapping(value = "/nq/customers")
    @ResponseStatus(HttpStatus.OK)
    List<CustomerEntity> getCustomerByNQ(@RequestParam String name);

}
