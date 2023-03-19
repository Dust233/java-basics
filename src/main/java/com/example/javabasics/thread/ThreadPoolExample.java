package com.example.javabasics.thread;

/**
 * @author LiJingZhi
 * @since 2023-03-06 0:23
 */

import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPoolExample {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    public static void main(String[] args) {
        Future<?> s = executorService.submit(() -> {
            System.out.println("s");
        });
        System.out.println(s.isDone());
        executorService.execute(() ->{
            System.out.println("ss");
        });
        // creates five tasks
        Task r1 = new Task();
        Task r2 = new Task();
        Task r3 = new Task();
        Task r4 = new Task();
        Task r5 = new Task();

        // submit方法有返回值
        Future future = executorService.submit(r1);
        System.out.println("r1 isDone ? " + future.isDone());

        // execute方法没有返回值
        executorService.execute(r2);
        executorService.execute(r3);
        executorService.execute(r4);
        executorService.execute(r5);

        //关闭线程池
        executorService.shutdown();

    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(2000);
                System.out.println(Thread.currentThread().getName() + " - " + LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class MyThreadFactory implements ThreadFactory {

        private final String namePrefix;

        public MyThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, namePrefix + "-" + threadNumber.getAndIncrement());
        }

    }

    private static final ExecutorService executorService = new ThreadPoolExecutor(
            10,
            20, 30, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
            new MyThreadFactory("线程池"),
            new ThreadPoolExecutor.AbortPolicy());



}
