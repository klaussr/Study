package com.Alex.javacore.chapter28;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

class Foo {
    Semaphore sSecond, sThird;

    public Foo() {
        sSecond = new Semaphore(0);
        sThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        print("first");
        sSecond.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        sSecond.acquire();
        printSecond.run();
        print("second");
        sThird.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        sThird.acquire();
        printThird.run();
        print("third");
    }

    public  void print(String s) {
        System.out.println(s);
    }
}

public class Exs {
    public static void main(String[] args) {
       Foo foo = new Foo();
        CompletableFuture.runAsync(() -> {
            try {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.second(new Thread());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.first(new Thread());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        CompletableFuture.runAsync(() -> {
            try {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.third(new Thread());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
    }
}
