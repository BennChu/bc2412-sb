package com.bootcamp.demo_sb_customer.model.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Data Transfer Object DTO
// model use for deserialization
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable{

    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;


        @Getter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Geo {
            @JsonProperty(value = "lat") // Json name is "lat", Jave name is latitude
            private String latitude;
            @JsonProperty(value = "lng")
            private String longitude; // Json name is "lat", Jave name is longtitude
        }
    }


    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Company {
        private String name;
        private String catchPrase;
        private String bs;
    }
}
