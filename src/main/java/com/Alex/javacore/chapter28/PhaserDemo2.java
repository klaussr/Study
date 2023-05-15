package com.Alex.javacore.chapter28;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    protected boolean onAdvance(int p, int regParties) {
        System.out.println("Фаза " + p + " завершена");
        if (p == numPhases || regParties == 0) return true;
        return false;
    }
}
public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Запуск потоков\n");

        new MyThread3(myPhaser, "A");
        new MyThread3(myPhaser, "B");
        new MyThread3(myPhaser, "C");

        while (!myPhaser.isTerminated()){
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизатор фаз завершен");
    }
}

class MyThread3 implements Runnable {
    Phaser phaser;
    String name;

    MyThread3(Phaser p, String s) {
        phaser = p;
        name = s;
        phaser.register();
        new Thread(this).start();
    }

    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Поток " + name + " начинает фазу " + phaser.getPhase());

            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
