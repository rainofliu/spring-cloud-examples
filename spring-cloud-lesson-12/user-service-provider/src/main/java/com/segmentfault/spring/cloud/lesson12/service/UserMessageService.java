package com.segmentfault.spring.cloud.lesson12.service;

import com.segmentfault.spring.cloud.lesson12.stream.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 用户-消息服务
 *
 * @author ajin
 */
@Service
public class UserMessageService {

    @Autowired
    private UserMessage userMessage;

    @PostConstruct
    public void init() {

        SubscribableChannel subscribableChannel = userMessage.input();

        subscribableChannel.subscribe(message -> {


        });
    }
}
