package com.Alex.javacore.patterns.structural.bridge;

public class Sailing extends Job{
    protected Sailing(Worker worker) {
        super(worker);
    }
    @Override
    public void doingJob() {
        System.out.println("Sailing in progress");
        worker.doingJob();
    }
}
