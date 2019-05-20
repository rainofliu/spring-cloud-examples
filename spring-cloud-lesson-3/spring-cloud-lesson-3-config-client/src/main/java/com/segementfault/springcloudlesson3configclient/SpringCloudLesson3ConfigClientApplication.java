package com.segementfault.springcloudlesson3configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@SpringBootApplication
public class SpringCloudLesson3ConfigClientApplication {

    private final ContextRefresher contextRefresher;

    @Autowired
    public SpringCloudLesson3ConfigClientApplication(
            ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson3ConfigClientApplication.class, args);
    }

    /**
     * 定时刷新配置
     */
    @Scheduled(fixedRate = 1000L)
    public void updateConfig() {

        Set<String> keys = contextRefresher.refresh();

        if (!keys.isEmpty()) {
            System.out.println("本次更新的配置项" + keys);
        }
    }

    @Bean
    public MyHealthIndicator myHealthIndicator() {

        return new MyHealthIndicator();
    }

//    @Component
    private class MyHealthIndicator implements HealthIndicator {

        @Override
        public Health health() {

            Health.Builder builder = Health.status(Status.UP);
            builder.withDetail("name", "ajin");
            builder.withDetail("timestamp", System.currentTimeMillis());

            return builder.build();
        }
    }

}
