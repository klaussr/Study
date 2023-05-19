package com.Alex.javacore.patterns.structural.decorator;

public class Task {
    public static void main(String[] args) {
        Worker worker = new Sailor();
        Worker cap = new Captain(new Botswain(new Sailor()));
        Worker botswain = new Botswain(new Sailor());

        System.out.println(worker.doingJob());
        System.out.println(cap.doingJob());
        System.out.println(botswain.doingJob());
    }
}
