package com.bootcamp.demo_sb_customer.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Autowired(required=false)
// indicating that the dependency is optional. 
// This means that if the Spring container cannot find a bean that matches the criteria,
//  it will not throw an exception. Instead, the field will simply be set to null
// CommandLineRunner commandLineRunner; somewhere in spring has this code so can call the below codes

// 可以 before server starts run this program, eg. check sth, 
// 搵到個 Bean @Component 就放入去, 

@Component // into Bean context
public class PreServerStartConfig implements CommandLineRunner{ //CommandLineRunner is a functional interface
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello"); // this is an example

        // call JPH users api
        // call JPH post api
        // call JPH comment api
        // save DB
    }
}
