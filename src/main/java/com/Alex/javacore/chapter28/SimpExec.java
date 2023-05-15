package com.Alex.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(5);
        CountDownLatch countDownLatch12 = new CountDownLatch(5);
        CountDownLatch countDownLatch13 = new CountDownLatch(5);
        CountDownLatch countDownLatch14 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");
        es.execute(new MYThread1(countDownLatch1, "A"));
        es.execute(new MYThread1(countDownLatch12, "B"));
        es.execute(new MYThread1(countDownLatch13, "C"));
        es.execute(new MYThread1(countDownLatch14, "D"));

        try {
            countDownLatch1.await();
            countDownLatch12.await();
            countDownLatch13.await();
            countDownLatch14.await();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        es.shutdown();
        System.out.println("Завершение потоков");
    }
}

class MYThread1 implements Runnable {
    String name;
    CountDownLatch latch;

    MYThread1(CountDownLatch c, String s) {
        latch = c;
        name = s;
        new Thread(this);
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " : " + i);
            latch.countDown();
        }
    }
}
