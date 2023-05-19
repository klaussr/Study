package com.Alex.javacore.patterns.structural.bridge;

public class Digging extends Job{
    protected Digging(Worker worker) {
        super(worker);
    }
    @Override
    public void doingJob() {
        System.out.println("Digging in progress");
        worker.doingJob();
    }
}
