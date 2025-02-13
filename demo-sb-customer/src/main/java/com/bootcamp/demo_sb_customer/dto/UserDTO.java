package com.bootcamp.demo_sb_customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// 撞名, 第二個同名 new 就會好長名
// 可以唔 need 咁多野
// DTO this is for serialization -> Object to Json
// 老細要求
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDTO {
    // UserDTO userDTO = new UserDTO();
    // UserDto userDto = new UserDto();
    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;

    
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;


        @Getter
        @Setter
        @Builder
        public static class Geo {
            // 之前 download from json name "lat" -> jave name "latitude" -> 出去 jason "x"
            @JsonProperty(value = "x")
            private String latitude;
            @JsonProperty(value = "y")
            private String longitude;
        }
    }


}
