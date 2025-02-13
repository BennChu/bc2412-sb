package com.bootcamp.demo_sb_customer.controller;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {

    // explicitly maps the query parameter cid to the customerId
    // http://localhost:8082/order?cid=2
    @PostMapping(value = "/order")
    ApiResp<OrderEntity> createOrder(@RequestParam(value = "cid") Long customerId,
            @RequestBody OrderEntity orderEntity);

    // assumes that the query parameter name is customerId
    // http://localhost/order?customerId=2
    // @PostMapping(value = "/order")
    // OrderEntity createOrder(@RequestParam Long customerId,
    //         @RequestBody OrderEntity orderEntity);

    // http://localhost/order?oid=2
    // @DeleteMapping(value = "/order")
    // OrderEntity deleteOrderById(@RequestParam(value = "oid") Long orderId);

}
