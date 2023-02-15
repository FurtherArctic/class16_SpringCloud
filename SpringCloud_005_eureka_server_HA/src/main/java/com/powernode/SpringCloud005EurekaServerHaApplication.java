package com.powernode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangjunchen 2020/12/22
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloud005EurekaServerHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud005EurekaServerHaApplication.class, args);
    }

}
