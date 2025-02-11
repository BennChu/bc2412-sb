package com.bootcamp.demo_sb_customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_sb_customer.controller.OrderOperation;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.demo_sb_customer.service.OrderService;

@RestController
public class OrderController implements OrderOperation {

    @Autowired
    private OrderService orderService;

    // explicitly maps the query parameter cid to the customerId
    // http://localhost/order/order?cid=2
    //@PostMapping(value = "/order/order?cid=2")
    @Override
    public OrderEntity createOrder(@RequestParam(value = "cid") Long customerId,
            @RequestBody OrderEntity orderEntity) {

            this.orderService.createOrder(customerId, orderEntity);

            return orderEntity;
    }
}
