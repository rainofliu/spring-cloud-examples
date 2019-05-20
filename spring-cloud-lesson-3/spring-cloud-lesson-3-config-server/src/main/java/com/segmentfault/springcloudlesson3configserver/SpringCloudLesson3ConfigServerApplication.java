package com.segmentfault.springcloudlesson3configserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringCloudLesson3ConfigServerApplication {




    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson3ConfigServerApplication.class, args);
//		E:\eclipse projects\Spring Cloud Lesson SegmentFault\spring-cloud-lesson-3-config-server
//		System.out.println(System.getProperty("user.dir"));
    }



}
