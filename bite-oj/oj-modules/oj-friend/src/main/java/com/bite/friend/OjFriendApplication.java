package com.bite.friend;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.bite.**.mapper")
@EnableFeignClients(basePackages = "com.bite.api")
public class OjFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjFriendApplication.class, args);
    }
}
