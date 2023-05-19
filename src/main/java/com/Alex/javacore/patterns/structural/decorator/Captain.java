package com.Alex.javacore.patterns.structural.decorator;

public class Captain extends WorkerDecorator{
    public Captain(Worker worker) {
        super(worker);
    }

    public String  makingVesselReview() {
        return "I am standing on the bridge and watch for my team\n";
    }

    @Override
    public String doingJob() {
        return super.doingJob() + makingVesselReview();
    }
}
