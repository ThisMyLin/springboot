package com.xiaozhai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * springboot启动类
 */

@SpringBootApplication
@EnableTransactionManagement
public class AppConfiguration {

    public static void main(String[] args) {

        SpringApplication.run(AppConfiguration.class,args);
    }
}
