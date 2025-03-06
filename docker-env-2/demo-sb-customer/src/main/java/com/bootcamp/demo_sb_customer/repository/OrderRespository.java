package com.bootcamp.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_customer.entity.OrderEntity;

@Repository // put it into Repository bean
public interface OrderRespository extends JpaRepository<OrderEntity, Long> {
    
}
