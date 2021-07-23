package com.kami.mall.java.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yangzi
 * @date 2021-07-07 10:37 AM
 */
public class ThreadLocalDemo {

    public static final ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        // 任务1
        Future<Boolean> booleanTask = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(10000);
                System.out.println("1");
                return true;
            }
        });

        // 任务2
        Future<String> stringTask = service.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("2");
                return "Hello World";
            }
        });


        // 获取任务1的返回值
        Boolean result1 = booleanTask.get();
        System.err.println("任务1-10s： " + result1);

        // 获取任务2的返回值
        String result2 = stringTask.get();
        System.err.println("任务2-3s： " + result2);

        // main方法执行：执行时间
        System.err.println("time: " + (System.currentTimeMillis() - start));
    }

}
