package com.ajin.springcloudlesson1.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring事件/监听器 Demo
 *
 * @Auther: ajin
 * @Date: 2019/1/22 19:36
 * @Description:
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationListener.class);
        // 1.增加监听器
        //context.addApplicationListener(new MyApplicationListener());
        //context.register(MyApplicationListener.class);
        // 2.上下文的启动
        //context.refresh();
        // 3.发布事件（上下文启动后才可以发布事件）
        context.publishEvent(new MyApplicationEvent("Hello,World"));
        // 发布事件后，监听器会自动监听到事件
        context.publishEvent(new MyApplicationEvent("123"));
        context.publishEvent(new MyApplicationEvent("125"));

    }

    //自定义一个事件监听器
    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
        /**
         * 对监听到的事件进行处理，当然，这里只是简单打印事件的信息
         * Handle an application event.
         *
         * @param event the event to respond to
         */
        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.printf("MyApplicationListener receieves event: %s\n", event.getSource());
        }
    }

    //自定义一个事件对象
    private static class MyApplicationEvent extends ApplicationEvent {
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
}
