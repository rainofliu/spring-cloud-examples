package com.ajin.springcloudlesson2.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ajin
 * @Date: 2019/1/31 10:49
 * @Description:
 */

public class MyPropertySourceLocator implements PropertySourceLocator {
    /**
     * @param environment the current Environment
     * @return a PropertySource or null if there is none
     * @throws IllegalStateException if there is a fail fast condition
     */
    @Override
    public PropertySource<?> locate(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment configurableEnvironment=ConfigurableEnvironment.class.cast(environment);
            MutablePropertySources propertySources=configurableEnvironment.getPropertySources();
            propertySources.addFirst(createPropertySource());
        }
        return null;
    }

    private PropertySource createPropertySource(){
        Map<String,Object> source=new HashMap<>();
        source.put("spring.application.name", "小马哥的 Spring Cloud 程序");
        // 设置名称和来源
        PropertySource propertySource = new MapPropertySource("over-bootstrap-property-source", source);
        return  propertySource;
    }
}
