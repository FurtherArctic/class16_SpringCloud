package com.powernode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangjunchen
 * EnableEurekaServer 启用eureka服务
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloud003EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud003EurekaServerApplication.class, args);
    }

}
