package com.bootcamp.demo_sb_customer.service.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_sb_customer.codewave.RedisManager;
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
import com.fasterxml.jackson.core.JsonProcessingException;

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
    // @Autowired
    // private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisManager redisManager;


    @Value("${api.jsonplaceholder.domain}")
    private String domain;

    @Value("${api.jsonplaceholder.endpoints.users}")
    private String usersEndpoint;


 // List 比較難做野
    @Override
    public List<UserDto> getUsers() throws JsonProcessingException{

        // Cache Pattern: Read Through
        // 1. Read Redis first, if found, return 
        // [{},{},{}]
        // String json = this.redisTemplate.opsForValue().get("jph-users");
        // "[{},{},{}]" -> java object (Deserialization)
        //ObjectMapper objectMapper = new ObjectMapper();
        // if (json != null) {
        //     UserDto[] userDtos = objectMapper.readValue(json, UserDto[].class);
        //     return Arrays.asList(userDtos);
        // }

        String key = "jph-users";
        UserDto[] userDtos1 = redisManager.get(key, UserDto[].class);
        if (userDtos1 != null) {
            return Arrays.asList(userDtos1);
        }
           

        // 2.
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

            // save userEntity table first
            UserEntity userEntity = this.userRespository.save(this.entityMapper.map(e));

            // 1. map first
            // 2. set foreign key on addressEntity table
            // 3. save addressEntity
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

        // 3. Write the users back to redis
        // java -> "[{},{},{}]"
        // String serializedJson = objectMapper.writeValueAsString(userDtos);
        // this.redisTemplate.opsForValue().set("jph-users", serializedJson, Duration.ofMinutes(1));

        // if there is RedisManger
        redisManager.set(key, userDtos1, Duration.ofSeconds(10));

        return userDtos; 
    }
}
