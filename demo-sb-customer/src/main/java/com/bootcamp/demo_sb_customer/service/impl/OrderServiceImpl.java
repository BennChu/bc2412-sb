package com.bootcamp.demo_sb_customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.demo_sb_customer.exception.BusinessException;
import com.bootcamp.demo_sb_customer.repository.CustomerRespository;
import com.bootcamp.demo_sb_customer.repository.OrderRespository;
import com.bootcamp.demo_sb_customer.service.OrderService;

@Service //put it into Service bean
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private OrderRespository orderRespository;

    // if customer id not found, throw new BusinessException ("Customer ID not found")

    @Override
    public OrderEntity createOrder(Long customerId, OrderEntity orderEntity) {
        //Optional<CustomerEntity> customerEntity = this.customerRespository.findById(customerId);
        CustomerEntity customerEntity = this.customerRespository.findById(customerId)
                                            .orElseThrow(() -> new BusinessException("Customer ID not found"));
                                            
        orderEntity.setCustomerEntity(customerEntity);
        // save orderEntity to DB
        return this.orderRespository.save(orderEntity);

    }
}
