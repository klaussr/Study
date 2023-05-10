package com.Alex.javacore.chapter11;

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дочерний поток создан " + t);
        t.start();
    }

    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Дочерний поток " + n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread1();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Главный поток прерван" + e);
        }
        System.out.println("Главный поток завершен");
    }
}
