package com.Alex.javacore.patterns.structural.bridge;

public class Sailor implements Worker{
    @Override
    public void doingJob() {
        System.out.println("I am going into the ocean");
    }
}
