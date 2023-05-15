package com.Alex.javacore.chapter11;

class newThread2 implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    newThread2(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток" + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ":" + i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag) wait();
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}
public class SuspendResume {
    public static void main(String[] args) {
        newThread2 ob1 = new newThread2("Один");
        newThread2 ob2 = new newThread2("Два");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Приостановка потока Один");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Возобновление потока Один");
            ob2.mySuspend();
            System.out.println("Приостановка потока Два");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e){ System.out.println("Главный поток прерван");}

        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {System.out.println("Главный поток прерван");}
        System.out.println("Главный поток завершен");

    }
}
