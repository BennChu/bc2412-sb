package com.bootcamp.demo_sb_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_sb_customer.entity.dto.CompanyEntity;

@Repository
public interface CompanyRespository extends JpaRepository<CompanyEntity, Long>{
    
}
