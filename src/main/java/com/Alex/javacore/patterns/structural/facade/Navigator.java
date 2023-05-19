package com.Alex.javacore.patterns.structural.facade;

public class Navigator extends Job {
    public void doJob(Plan plan) {
        if (plan.isActiveTrip()) {
            System.out.println("Navigator is planning the route");
        }
        else System.out.println("Navigator is drinking his tea");
    }
}
