package com.bootcamp.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.demo_sb_customer.controller.impl.CalculatorController;
import com.bootcamp.demo_sb_customer.service.CalculatorService;

// Spring Boot framework for testing Spring MVC controllers in a slice 
// of the application context. It focuses solely on the web layer, allowing
// you to test your controllers in isolation without loading the entire application context
@WebMvcTest(controllers = CalculatorController.class) // focuse only on controller class
public class CalculatorControllerTest {
    @MockBean
    private CalculatorService calculatorService; // the CalculatorController depends on it

    @Autowired
    private MockMvc mockMvc; // Inject MockMvc performing Http request

    // this unit test case is to test 2 things
    // 1. jsonPath("$.value") -> the reponse must be an object
    // 2. the logic is to test if the result of sum() minus the result of subtract()
    @Test
    void calculatorTest() throws Exception {
        // Mock the behavior of the CalculatorService methods
        // 模擬 methods 個結果
        Mockito.when(calculatorService.sum(1, 2)).thenReturn(100);
        Mockito.when(calculatorService.subtract(1, 2)).thenReturn(200);

        // test
        // perform the GET request and assert the response
        // perform GET request with path variables
        // get and jsonPath need 手動 import static methods
        mockMvc.perform(get("/calculate/{x}/{y}", 1, 2)) //
            .andExpect(jsonPath("$.value").value(-100));
            // This asserts that the response is a JSON object with a value field equal to -100.
            // can add more assertions to verify the HTTP   
            //.andExpect(status().isOk()) // Assert HTTP 200 status
            //.andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Assert JSON content type
    }

}
