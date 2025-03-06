package com.bootcamp.demo_sb_customer;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.repository.CustomerRespository;
import com.bootcamp.demo_sb_customer.service.CustomerService;

@SpringBootTest // 幫我起個 enviorment 係齊 Bean
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRespository customerRespository; // 模擬 database 攞 which 番黎唔重要

    @Test
    void testGetAllCustomers() {
        // Mock behaviour for Mock Bean
        CustomerEntity customerEntity1 = CustomerEntity.builder()
            .email("john@gmail.com").name("john").id(1L).build();

        CustomerEntity customerEntity2 = CustomerEntity.builder()
            .email("mary@gmail.com").name("mary").id(2L).build();
   
        List<CustomerEntity> dbresult = Arrays.asList(customerEntity1, customerEntity2);

        // expected return
        Mockito.when(customerRespository.findAll()).thenReturn(dbresult);

        // test
        List<CustomerEntity> customerEntities = customerService.getCustomers();

        MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(
            Matchers.hasProperty(null)
        ));
   
    }
}
