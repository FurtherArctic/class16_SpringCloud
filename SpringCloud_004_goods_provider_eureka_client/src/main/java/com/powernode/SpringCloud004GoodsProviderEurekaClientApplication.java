package com.powernode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.powernode.dao")
public class SpringCloud004GoodsProviderEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud004GoodsProviderEurekaClientApplication.class, args);
    }

}
