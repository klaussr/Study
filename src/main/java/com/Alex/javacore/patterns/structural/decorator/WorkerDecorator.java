package com.Alex.javacore.patterns.structural.decorator;

public class WorkerDecorator implements Worker{
    private Worker worker;

    public WorkerDecorator(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String doingJob() {
        return worker.doingJob();
    }
}
