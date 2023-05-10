package com.Alex.javacore.chapter11;

class newThread implements Runnable {
    String name;
    Thread t;

    newThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(name + " : " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new newThread("Один");
        new newThread("Два");
        new newThread("Три");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван" + e);
        }
        System.out.println("Главный поток завершен");
    }
}

