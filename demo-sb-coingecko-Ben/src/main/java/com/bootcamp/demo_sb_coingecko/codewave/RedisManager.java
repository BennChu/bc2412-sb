package com.bootcamp.demo_sb_coingecko.codewave;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisManager {
     private RedisTemplate<String, String> redisTemplate;
    private ObjectMapper objectMapper;

    public RedisManager(RedisConnectionFactory factory, ObjectMapper objectMapper) throws JsonProcessingException {
        // Objects.requireNonNull(factory);
        // Objects.requireNonNull(objectMapper);
        this.redisTemplate = new RedisTemplate<>();
        this.redisTemplate.setConnectionFactory(factory);
        this.redisTemplate.setKeySerializer(RedisSerializer.string());
        this.redisTemplate.setValueSerializer(RedisSerializer.json());
        this.redisTemplate.afterPropertiesSet();
        this.objectMapper = objectMapper;

    }
    // UserDto userDto = RestTemplate.getForObject(url, UserDto[].class)
    public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {
        String json = this.redisTemplate.opsForValue().get(key);
        return json == null ? null : objectMapper.readValue(json, clazz);
    }

    public void set(String key, Object object, Duration duration) throws JsonProcessingException {
        String serializedJson = objectMapper.writeValueAsString(object);
        this.redisTemplate.opsForValue().set(key, serializedJson, duration);
    }

  
}
