package com.cn.jiajiao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;

    @Test
    public void testInsert(){
        redisTemplate.opsForValue().set("key","value");
        System.out.println("redis正常");
    }


    @Test
    public void testGet(){
        Object value = redisTemplate.opsForValue().get("key");
        System.out.println("value: "+value);
    }

}
