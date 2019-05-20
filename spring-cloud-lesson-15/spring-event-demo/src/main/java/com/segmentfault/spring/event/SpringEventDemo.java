package com.segmentfault.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * Spring 事件 demo
 *
 * @author ajin
 */

public class SpringEventDemo {


    public static void main(String[] args) {

        // 创建 Annotation 驱动的 Spring 应用上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 注册EventConfiguration到Spring应用上下文(事件监听器的配置）
        context.register(EventConfiguration.class);

        // 启动上下文
        context.refresh();

        // 定义事件的发布源
        ApplicationEventPublisher publisher = context;

        // 发布一个事件
        publisher.publishEvent(new MyApplicationEvent("Hello World ! "));
    }

    /**
     * 自定义事件
     */
    private static class MyApplicationEvent extends ApplicationEvent {


        /**
         * Create a new ApplicationEvent.
         *
         * @param message the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(String message) {
            super(message);
        }
    }

    @Configuration
    public static class EventConfiguration {

        /**
         * 监听{@link MyApplicationEvent}事件
         * @param event MyApplicationEvent
         * */
        @EventListener
        public void onEvent(MyApplicationEvent event) {

            System.out.println("监听到事件："+event);

        }

    }

}
