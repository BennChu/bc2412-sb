package com.bootcamp.demo_sb_customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.bootcamp.demo_sb_customer.controller.impl.UserController;
import com.bootcamp.demo_sb_customer.dto.UserDTO;
import com.bootcamp.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.bootcamp.demo_sb_customer.model.dto.UserDto;
import com.bootcamp.demo_sb_customer.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// default is the whole 
// 鎖定 only test UserController.class
// @SpringBootTest 係 real 去 DB

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    // 睇下 load 唔 load 到
    // @Test
    // void contextLoad() {
        
    // }

    
    @MockBean // 做一個假 Bean , 冇行為, 如果有 10 個 method 就要 mock 10 個
    private UserService userService; // this is interface, just agree input and output, 分離左, 可以做 unit test

    @SpyBean //spyBean 模擬 10 methods real 10 methods, still mock method//@MockBean
    private UserDTOMapper userDTOMapper; 
    // important list of a to list of b
    // Map 錯都唔重要
    // 重要係 map 到
    
    // 自帶係 context 有
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUsers() throws Exception{ // throws unhandled exception type exception
        // Controller: convert List of Dto to List of DTO
        // bcoz Dto has null pointer exception cannot convert
        // build object John only set John name, others values are null
        UserDto.Address.Geo johnGeo = UserDto.Address.Geo.builder().build();
        UserDto.Address johnAddress = UserDto.Address.builder().geo(johnGeo).build();
        UserDto.Company johnCompany = UserDto.Company.builder().build();
        UserDto john = UserDto.builder().name("John").address(johnAddress).company(johnCompany).build();

        // Mary
        UserDto.Address.Geo maryGeo = UserDto.Address.Geo.builder().build();
        UserDto.Address maryAddress = UserDto.Address.builder().geo(maryGeo).build();
        UserDto.Company maryCompany = UserDto.Company.builder().build();
        UserDto mary = UserDto.builder().name("Mary").address(maryAddress).company(maryCompany).build();

        // put them into a List of UserDto
        List<UserDto> userDtos = Arrays.asList(john, mary);

        Mockito.when(userService.getUsers()).thenReturn(userDtos);

        ResultActions result = mockMvc.perform(get("/jsonplaceholder/users"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // To check the data:
        String json = result.andReturn().getResponse().getContentAsString();

        List<UserDTO> userDTOs = new ObjectMapper().readValue( //
                            json, new TypeReference<List<UserDTO>>() {});
        
        // hramcrest library
        MatcherAssert.assertThat(userDTOs, Matchers.containsInAnyOrder( //
            Matchers.hasProperty("name", Matchers.equalTo("John")),
            Matchers.hasProperty("name", Matchers.equalTo("Mary"))
        ));

    }

}
