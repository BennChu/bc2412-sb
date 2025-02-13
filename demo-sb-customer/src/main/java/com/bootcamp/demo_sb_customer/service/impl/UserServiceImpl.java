package com.bootcamp.demo_sb_customer.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_sb_customer.entity.dto.AddressEntity;
import com.bootcamp.demo_sb_customer.entity.dto.CompanyEntity;
import com.bootcamp.demo_sb_customer.entity.dto.GeoEntity;
import com.bootcamp.demo_sb_customer.entity.dto.UserEntity;
import com.bootcamp.demo_sb_customer.entity.mapper.EntityMapper;
import com.bootcamp.demo_sb_customer.model.dto.UserDto;
import com.bootcamp.demo_sb_customer.repository.AddressRespository;
import com.bootcamp.demo_sb_customer.repository.CompanyRespository;
import com.bootcamp.demo_sb_customer.repository.GeoRespository;
import com.bootcamp.demo_sb_customer.repository.UserRespository;
import com.bootcamp.demo_sb_customer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private CompanyRespository companyRespository;
    @Autowired
    private AddressRespository addressRespository;
    @Autowired
    private GeoRespository geoRespository;
    @Autowired // bcoz use @Component at EntityMapper class
    private EntityMapper entityMapper;


    @Value("${api.jsonplaceholder.domain}")
    private String domain;

    @Value("${api.jsonplaceholder.endpoints.users}")
    private String usersEndpoint;


 // List 比較難做野
    @Override
    public List<UserDto> getUsers() {
        //String url = "https://jsonplaceholder.typicode.com/users";

        // url, uri
        String url = UriComponentsBuilder.newInstance()
                        .scheme("https")
                        .host(domain)
                        .path(usersEndpoint)
                        .build()
                        .toUriString();
        System.out.println("url= " + url);

        // save user list to db before return
        List<UserDto> userDtos = 
            Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class)); 

        // delete DB, bcoz has foreign key, so when we delete tables
        // need to follow order
        this.geoRespository.deleteAll();
        this.addressRespository.deleteAll();
        this.companyRespository.deleteAll();
        this.userRespository.deleteAll();
        
        // bcoz every time we delete tables first then save database
        // so every time we only have same record
        // but id is auto increment, will keep increasing

        // save DB procedures
        userDtos.stream().forEach(e -> {
            UserEntity userEntity = this.userRespository.save(this.entityMapper.map(e));

            AddressEntity addressEntity = this.entityMapper.map(e.getAddress());
            addressEntity.setUserEntity(userEntity);
            this.addressRespository.save(addressEntity);

            CompanyEntity companyEntity = this.entityMapper.map(e.getCompany());
            companyEntity.setUserEntity(userEntity);
            this.companyRespository.save(companyEntity);

            GeoEntity geoEntity = this.entityMapper.map(e.getAddress().getGeo());
            geoEntity.setAddressEntity(addressEntity);
            this.geoRespository.save(geoEntity);

        });

        return null; 
    }
}
