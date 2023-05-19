package com.Alex.javacore.chapter28;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

class Foo {
    Semaphore sSecond, sThird;

    public Foo() {
        sSecond = new Semaphore(0);
        sThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) {
        printFirst.run();
        print("first");
        sSecond.release();
    }

    public void second(Runnable printSecond) {
        try {
            sSecond.acquire();
            printSecond.run();
            print("second");
            sThird.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    public void third(Runnable printThird) {
        try {
            sThird.acquire();
            printThird.run();
            print("third");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void print(String s) {
        System.out.println(s);
    }
}

public class Exs {
    public static void main(String[] args) {
        Foo foo = new Foo();
        CompletableFuture.runAsync(() -> {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.second(new Thread());
        });
        CompletableFuture.runAsync(() -> {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.first(new Thread());
        });
        CompletableFuture.runAsync(() -> {
                //noinspection InstantiatingAThreadWithDefaultRunMethod
                foo.third(new Thread());
        });
    }
}
