package com.Alex.javacore.patterns.structural.bridge;

public class Digger implements Worker{
    @Override
    public void doingJob() {
        System.out.println("I dig a hole");
    }
}
