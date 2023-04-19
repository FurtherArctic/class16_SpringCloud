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
public class SpringCloud008OrderConsumerOpenfeignMultiparameterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud008OrderConsumerOpenfeignMultiparameterApplication.class, args);
    }

}
