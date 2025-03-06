package com.bootcamp.demo_sb_customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.repository.CustomerRespository;

@DataJpaTest // load repository related beans only
public class CustomerRespositoryTest {
    @Autowired
    private CustomerRespository customerRespository;

    // first, we do not write these codes
    @Test
    void testSave() {
     
        List<CustomerEntity> beforeSave = customerRespository.findAll();

        assertEquals(0, beforeSave.size());
     
        CustomerEntity john = CustomerEntity.builder()
            .email("john@gmail.com").name("john").build();
            // id is auto increment , no need to set id
    
        CustomerEntity customerEntity = customerRespository.save(john);

        assertEquals("john", customerEntity.getName());
        assertEquals("john@gmail.com", customerEntity.getEmail());
        assertEquals("1L", customerEntity.getId()); // 可以 check 佢 id

        List<CustomerEntity> afterSaveJohn = customerRespository.findAll();
        



        // 做多個 mary 睇下 id 係咪 2L
        CustomerEntity mary = CustomerEntity.builder()
            .email("mary@gmail.com").name("mary").build();

            CustomerEntity customerEntity2 = customerRespository.save(mary);

            assertEquals("mary", customerEntity.getName());
            assertEquals("mary@gmail.com", customerEntity.getEmail());
            assertEquals("2L", customerEntity.getId());


        
    }

    @Test
    void testfindAll() {

        // 可以 test 埋 findAll(), 因為佢可以係 db insert Mary 之後 delete John
        // 所以 try 下 findAll(), 睇下 db 係咪真係有 John and Mary

        






    }
    
}
