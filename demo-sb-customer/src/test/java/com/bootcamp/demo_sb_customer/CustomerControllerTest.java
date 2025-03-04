package com.bootcamp.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import com.bootcamp.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.demo_sb_customer.controller.impl.CustomerController;
import com.bootcamp.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo_sb_customer.service.CustomerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


// 尾要 test
// every test file is a testing enviroment with your target bean cycle
// 如果放, no need public
// for unit test for controller, we do not need service & respository layer (bean)
// 限制佢攞野, 
// CustomerController 內有 Autowired
@WebMvcTest(controllers = CustomerController.class) // Context includes all web related beans ONLY, 可以寫死佢 (Customer)
public class CustomerControllerTest {
    @MockBean // 假 bean 
    private CustomerService customerService;

    // @WebMvcTest inject MockMvc Bean into context
    @Autowired
    private MockMvc mockMvc; // pretend Postman , 自己 start server test 自己 shut server

    @Test
    void testGetAllCustomers() throws Exception{

        // Mock behavior for the mock bean
        CustomerEntity customerEntity1 = CustomerEntity.builder()
                                            .email("test123@gmail.com")
                                            .name("testname1")
                                            .id(99L)
                                            .build();
        CustomerEntity customerEntity2 = CustomerEntity.builder()
                                            .email("test234@gmail.com")
                                            .name("testname2")
                                            .id(999L)
                                            .build();

        // Arrays.List.of cannot add or remove
        // asList
        List<CustomerEntity> serviceResult = Arrays.asList(customerEntity1, customerEntity2);

        // Assume the behavior/result for the mock bean
        Mockito.when(customerService.getCustomers()).thenReturn(serviceResult);

        
        // Test
        // verify result
        // result.andExpect(MockMvcResultMatchers.status().isOk())
        // ResultActions is an interface
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/customers"));

        result.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // to check the data:
        // Approach 1
        result.andExpect(jsonPath("$.code").value("000000"))    //
              .andExpect(jsonPath("$.message").value("Success."))   //
              .andExpect(jsonPath("$.data[0].name").value("testname1")) //
              .andExpect(jsonPath("$.data[0].email").value("test123@gmail.com"));
        // then mvn clean test

        // Approach 2
        String json = result.andReturn().getResponse().getContentAsString();

        // JSON -> Object (Deserialization)
        // TypeReference is from Jackson (JSON) library
        ApiResp<List<CustomerEntity>> customerEntityArray =                                            //
            new ObjectMapper().readValue(json, new TypeReference<ApiResp<List<CustomerEntity>>>() {}); // 係CsutomerEntity is array, can put into List
    
        List<CustomerEntity> customerEntities = customerEntityArray.getData();

        // MatcherAssert is from harmcrest library
        MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(     //
            Matchers.hasProperty("email", Matchers.equalTo("test123@gamil.com")),   //
            Matchers.hasProperty("email", Matchers.equalTo("test234@gmail.com"))    //
        ));
    
    
    
    }

    // !!! remember throws Exception
    @Test
    void testCreateCustomer() throws Exception{

        // mock behavior (pass mary return john)
        CustomerEntity customerEntity = CustomerEntity.builder()
                                            .email("john@gmail.com")
                                            .name("John Wong")
                                            .id(9999L)
                                            .build();

        CustomerEntity customerEntityRequest = CustomerEntity.builder()
                                            .email("mary@gmail.com")
                                            .name("Mary")
                                            .id(11L)
                                            .build();


        // Assume the behavior/result for the mock bean
        // pass Mary become John
        Mockito.when(customerService.createCustomer(customerEntityRequest)).thenReturn(customerEntity);

        // customerEntityRequest to string and declare mary json
        String requestBodyJson = 
            new ObjectMapper().writeValueAsString(customerEntityRequest); // this is string

    
        ResultActions result = mockMvc
        .perform(post("/customer").contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(requestBodyJson))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    // ! Get Response, extract response data to validate
    String json = result.andReturn().getResponse().getContentAsString();

    // Deserialization
    // ! KEY
    ApiResp<CustomerEntity> apiResp = new ObjectMapper().readValue(json,
        new TypeReference<ApiResp<CustomerEntity>>() {});

    MatcherAssert.assertThat(apiResp.getCode(), Matchers.is("000000"));
    MatcherAssert.assertThat(apiResp.getMessage(), Matchers.is("Success."));

    CustomerEntity responseData = apiResp.getData();
    MatcherAssert.assertThat(responseData.getName(), Matchers.is("John Wong"));

    verify(customerService, times(1)).createCustomer(customerEntityRequest);

        // Test
        // verify result
        // result.andExpect(MockMvcResultMatchers.status().isOk())
        
        
        
        // ResultActions is an interface
        // unhandled exception type exception
        // ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/customer").content(RequestBody));

        // String contentType = result.andReturn().getResponse().getContentType();
        // System.out.println("Response Content Type: " + contentType);
    
        // result.andExpect(status().isBadRequest())   // 200 is ok, 400 is Bad Request
        //       .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // to check the data:
        // Approach 1
        // result.andExpect(jsonPath("$.code").value("000000"))    //
        //       .andExpect(jsonPath("$.message").value("Success."))  //
        //       .andExpect(jsonPath("$.data.name").value("testname3")) //
        //       .andExpect(jsonPath("$.data.email").value("test345@gmail.com"));
        //       // then mvn clean test 

        // String json = result.andReturn().getResponse().getContentAsString();

        // System.out.println("Json = " + json);

    
    }
}
