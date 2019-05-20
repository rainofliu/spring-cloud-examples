package com.segumentfault.spring.cloud.lesson15.user.bus;

import com.segumentfault.spring.cloud.lesson15.event.UserRemoteApplicationEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

/**
 * 用户提供方 Bus 配置
 *
 * @author ajin
 */
@Configuration
@RemoteApplicationEventScan(basePackageClasses = UserRemoteApplicationEvent.class)
public class UserServiceProviderBusConfiguration {


}