package com.segumentfault.spring.cloud.lesson15.user.service.client.web.controller;

import com.segumentfault.spring.cloud.lesson15.domain.User;
import com.segumentfault.spring.cloud.lesson15.event.UserRemoteApplicationEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bus 事件 {@link Controller}
 *
 * @author ajin
 */
@RestController
public class BusEventController implements ApplicationEventPublisherAware, ApplicationContextAware {

    /**
     * 事件发布器
     */
    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationContext applicationContext;

    @PostMapping("/bus/event/publish/user")
    public boolean publishUserEvent(@RequestBody User user,
                                    @RequestParam(value = "destination", required = false) String destination) {

        String serviceInstanceId = applicationContext.getId();

        // 构造事件
        UserRemoteApplicationEvent event = new UserRemoteApplicationEvent
                (user, serviceInstanceId, destination);

        // 发布事件
        applicationEventPublisher.publishEvent(event);

        return true;

    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
