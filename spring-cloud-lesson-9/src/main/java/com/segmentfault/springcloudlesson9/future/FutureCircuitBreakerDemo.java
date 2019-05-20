package com.segmentfault.springcloudlesson9.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 通过{@link java.util.concurrent.Future}来实现服务熔断
 *
 * @author ajin
 */

public class FutureCircuitBreakerDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 初始化线程池 创建一个Executor，它使用单个工作线程操作
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        RandomCommand command = new RandomCommand();

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return command.run(); // 获取run()计算结果
            }
        });

        String result = null;

        // 100毫秒超时时间
        try {

            result=future.get(100, TimeUnit.MILLISECONDS);

        } catch (TimeoutException e) {

            // fallback方法
            result = command.fallback();
        }

        System.out.println(result);

        executorService.shutdown();

    }

    /**
     * 随机对象
     */
    private static final Random random = new Random();


    /**
     * 随机事件执行命令
     */
    public static class RandomCommand implements Command<String> {

        @Override
        public String run() throws InterruptedException {

            long executeTime = random.nextInt(200);

            // 通过休眠来模拟执行时间
            System.out.println("Execute Time :" + executeTime);

            Thread.sleep(executeTime);

            return "Hello World";
        }

        @Override
        public String fallback() {
            return "Fall back";
        }
    }


    public static interface Command<T> {

        /**
         * 正常执行并且返回结果
         */
        T run() throws InterruptedException;

        /**
         * 错误时返回的容错结果
         */
        T fallback();

    }
}
