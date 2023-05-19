package com.Alex.javacore.patterns.structural.bridge;


public abstract class Job {
    protected Worker worker;

    protected Job(Worker worker) {
        this.worker = worker;
    }

    public abstract void doingJob();
}
