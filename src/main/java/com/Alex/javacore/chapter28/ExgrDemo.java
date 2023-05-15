package com.Alex.javacore.chapter28;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new UseString(exchanger);
        new MakeString(exchanger);
    }
}

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;
    MakeString(Exchanger<String> s) {
        ex = s;
        str = new String();
        new Thread(this).start();
    }
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }
            try {
                str = ex.exchange(str);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class UseString implements Runnable {
    Exchanger<String> ex;
    String str;
    UseString(Exchanger<String> s) {
        ex = s;
        new Thread(this).start();
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Получено " + str);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
