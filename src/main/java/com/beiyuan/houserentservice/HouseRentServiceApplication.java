package com.beiyuan.houserentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beiyuan.houserentservice.infrastructure.database.mapper")
public class HouseRentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseRentServiceApplication.class, args);
    }

}
