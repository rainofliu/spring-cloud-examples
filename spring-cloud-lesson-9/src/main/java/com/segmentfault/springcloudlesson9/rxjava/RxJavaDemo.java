package com.segmentfault.springcloudlesson9.rxjava;

import rx.Single;

/**
 * RxJava 1.x 示例
 * @author ajin
 */

public class RxJavaDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        Single.just("Hello RxJava") // 仅能发布单条数据
        .subscribe(System.out::println)   // 订阅并且消费数据
        ;
    }
}
