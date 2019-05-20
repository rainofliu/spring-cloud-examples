package com.ajin.springcloudlesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudLesson2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson2Application.class, args);
/**
 * 另一种写法
 * SpringApplication springApplication=new SpringApplication(SpringCloudLesson2Application.class);
 * springApplication.run(args);l
 * */
    }

}

