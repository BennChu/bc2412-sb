package com.bootcamp.demo_sb_customer.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_sb_customer.entity.dto.AddressEntity;
import com.bootcamp.demo_sb_customer.entity.dto.CompanyEntity;
import com.bootcamp.demo_sb_customer.entity.dto.GeoEntity;
import com.bootcamp.demo_sb_customer.entity.dto.UserEntity;
import com.bootcamp.demo_sb_customer.model.dto.UserDto;

@Component // Spring automatically detects it during classpath scanning and registers it as a bean in the application context
public class EntityMapper {
    public UserEntity map(UserDto dto) {
        return UserEntity.builder()
                    .email(dto.getEmail())
                    .name(dto.getName())
                    .username(dto.getUsername())
                    .website(dto.getWebsite())
                    .phone(dto.getPhone())
                    .build();             
    }

    public AddressEntity map(UserDto.Address address) {
        return AddressEntity.builder()
                    .street(address.getStreet())
                    .city(address.getCity())
                    .suite(address.getSuite())
                    .zipcode(address.getZipcode())
                    .build();
    }

    public CompanyEntity map(UserDto.Company company) {
        return CompanyEntity.builder()
                    .catchPrase(company.getCatchPrase())
                    .bs(company.getBs())
                    .name(company.getName())
                    .build();
    }

    public GeoEntity map(UserDto.Address.Geo geo) {
        return GeoEntity.builder()
                    .latitude(Double.valueOf(geo.getLatitude())) //bcoz getLatitude is String so force it to Double maybe exception
                    .longitude(Double.valueOf(geo.getLongitude()))
                    .build();
    }
}
