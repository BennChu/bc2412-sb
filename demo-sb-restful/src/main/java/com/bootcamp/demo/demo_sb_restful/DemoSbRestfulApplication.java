package com.bootcamp.demo.demo_sb_restful;

//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// @Component scann -> Search the whole project, check if any @Contoller, @Service, Repository, Configuration
// spring 多左 bean, server 存在, 佢地就存在
// @Contoller, @Service, Repository, Configuration are a type of Component and put them into spring context
// they are no pointer, 
public class DemoSbRestfulApplication {

    //
    public static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    context = 
      SpringApplication.run(DemoSbRestfulApplication.class, args);
  }

}
