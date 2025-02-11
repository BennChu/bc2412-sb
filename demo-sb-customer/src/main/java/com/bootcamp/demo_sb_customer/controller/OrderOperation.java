package com.bootcamp.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {

    // explicitly maps the query parameter cid to the customerId
    // http://localhost:8082/order/order?cid=2
    @PostMapping(value = "/order/order?cid")
    OrderEntity createOrder(@RequestParam(value = "cid") Long customerId,
            @RequestBody OrderEntity orderEntity);

    // assumes that the query parameter name is customerId
    // http://localhost/order/order?customerId=2
    // @PostMapping(value = "/order/order?cid=2")
    // OrderEntity createOrder(@RequestParam Long customerId,
    //         @RequestBody OrderEntity orderEntity);

}
