package com.Alex.javacore.patterns.structural.decorator;

public class Botswain extends WorkerDecorator{

    public Botswain(Worker worker) {
        super(worker);
    }

    public String makingReview() {
        return "I go by the deck and review the salor's work\n";
    }

    @Override
    public String doingJob() {
        return super.doingJob() + makingReview();
    }
}
