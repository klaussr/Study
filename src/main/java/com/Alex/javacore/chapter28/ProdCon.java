package com.Alex.javacore.chapter28;

import java.util.concurrent.Semaphore;

class W {
    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа Interrupted Exception");
        }
        System.out.println("Получено " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа Interrupted Exception");
        }
        this.n = n;
        System.out.println("Отправлено " + n);
        semCon.release();
    }
}

class Producer implements Runnable{
    W w;
    Producer(W w) {
        this.w = w;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            w.put(i);
        }
    }
}
class Consumer implements Runnable{
    W w;
    Consumer(W w) {
        this.w = w;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            w.get();
        }
    }
}


public class ProdCon {
    public static void main(String[] args) {
        W w = new W();
        new Consumer(w);
        new Producer(w);
    }
}
