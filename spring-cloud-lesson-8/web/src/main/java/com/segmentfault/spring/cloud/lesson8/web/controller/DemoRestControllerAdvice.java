package com.segmentfault.spring.cloud.lesson8.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

/**
 * {@link DemoRestController} 类似于AOP拦截
 * <p>
 *     Spring Boot全局异常处理
 *
 * @author: ajin
 * @since 0.0.1
 */
@RestControllerAdvice(assignableTypes = {DemoRestController.class}) // 设置拦截指定RestController接口类
public class DemoRestControllerAdvice {


    @ExceptionHandler(value = TimeoutException.class) // 拦截指定异常
    public Object faultTolerance(Throwable throwable) {
        return throwable.getMessage();
    }

}
