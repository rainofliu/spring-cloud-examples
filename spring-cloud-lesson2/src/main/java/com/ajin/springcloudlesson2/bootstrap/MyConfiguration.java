package com.ajin.springcloudlesson2.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: ajin
 * @Date: 2019/1/31 10:28
 * @Description:
 */
@Configuration
public class MyConfiguration implements ApplicationContextInitializer {
    /**
     * Initialize the given application context.
     *
     * @param applicationContext the application to configure
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //1.通过上下文对象获取Environment
       ConfigurableEnvironment environment= applicationContext.getEnvironment();
       //2.获取MutablePropertySources
       MutablePropertySources propertySources=environment.getPropertySources();
       //3.定义一个新的 PropertySource，并且放置在首位
        propertySources.addFirst(createPropertySource());
    }
    private PropertySource createPropertySource(){
        Map<String,Object> source=new HashMap<>();
        source.put("小马哥","Alibaba");
        PropertySource propertySource=new MapPropertySource("spring-clou-new-properties",source);
        return  propertySource;
    }
}
