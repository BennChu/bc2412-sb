package com.bootcamp.demo_sb_customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_sb_customer.codewave.BusinessException;
import com.bootcamp.demo_sb_customer.codewave.SysCode;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;
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
                                            .orElseThrow(() -> BusinessException.of(SysCode.ID_NOT_FOUND)); // new BusinessException("Customer ID not found"
                                            
        orderEntity.setCustomerEntity(customerEntity);
        // save orderEntity to DB
        return this.orderRespository.save(orderEntity);

    }

    // @Override
    // public OrderEntity deleteOrderById(Long orderId) {

    //     OrderEntity orderEntity = this.orderRespository.findById(orderId)
    //                                     .orElseThrow(() -> new BusinessException("Order ID not found"));

    //     this.orderRespository.delete(orderEntity);                    
        
    //     return orderEntity;
    // }

}