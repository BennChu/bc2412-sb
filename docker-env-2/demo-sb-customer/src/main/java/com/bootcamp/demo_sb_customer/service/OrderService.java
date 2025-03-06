package com.bootcamp.demo_sb_customer.service;

import com.bootcamp.demo_sb_customer.entity.OrderEntity;

public interface OrderService {

    OrderEntity createOrder(Long customerId, OrderEntity orderEntity);

    //OrderEntity deleteOrderById(Long orderId);
}
