package com.powernode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangjunchen
 */
@SpringBootApplication
@MapperScan("com.powernode.dao")
@EnableFeignClients
public class SpringCloud007OrderConsumerOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud007OrderConsumerOpenfeignApplication.class, args);
    }

}
