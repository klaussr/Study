package com.Alex.javacore.chapter11;

class newThread1 implements Runnable {
    String name;
    Thread t;

    newThread1(String threadName) {
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

public class DemoJoin {
    public static void main(String[] args) {
        newThread1 ob1 = new newThread1("Один");
        newThread1 ob2 = new newThread1("Два");
        newThread1 ob3 = new newThread1("Три");

        System.out.println("Поток Один запущен " + ob1.t.isAlive());
        System.out.println("Поток Два запущен " + ob2.t.isAlive());
        System.out.println("Поток Три запущен " + ob3.t.isAlive());


        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван" + e);
        }
        System.out.println("Поток Один запущен " + ob1.t.isAlive());
        System.out.println("Поток Два запущен " + ob2.t.isAlive());
        System.out.println("Поток Три запущен " + ob3.t.isAlive());
        System.out.println("Главный поток завершен");

    }
}

