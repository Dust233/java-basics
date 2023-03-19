package com.example.javabasics.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LiJingZhi
 * @since 2023-03-05 22:49
 */

@SpringBootTest

public class ThreadTest {
    private static ThreadLocal<String> tl = new ThreadLocal<>();
    private String content;

    public static void main(String[] args) {
        threadLocaltest();

    }

    private String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

//    private String getContent() {
//        return tl.get();
//    }
//
//    private void setContent(String content) {
//        tl.set(content);
//    }

    public static void threadLocaltest(){
        ThreadTest demo = new ThreadTest();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());

                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }

    @Test
    public void getTl() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
