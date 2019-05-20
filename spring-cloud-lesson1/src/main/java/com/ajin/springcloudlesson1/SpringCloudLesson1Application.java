package com.ajin.springcloudlesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudLesson1Application {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCloudLesson1Application.class, args);
		SpringApplication springApplication=new SpringApplication(SpringCloudLesson1Application.class);
		// 设置web环境
		springApplication.setWebEnvironment(true);
		springApplication.run(args);
	}

}

