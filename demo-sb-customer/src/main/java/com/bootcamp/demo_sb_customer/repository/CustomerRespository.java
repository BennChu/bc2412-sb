package com.bootcamp.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;

// JPA + Driver (Postgresql)
// Hibernate generates the implementation class, which implements "CustomerRespository"

// crud, create read update delete operation
@Repository //Respository bean
public interface CustomerRespository extends JpaRepository<CustomerEntity, Long> {
    
    // During maven compilation, the implementation class is generated by Hibernate
    
    // findAll
    // save
    // saveAll
    // deleteById
    
}
