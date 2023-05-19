package com.Alex.javacore.patterns.structural.facade;

public class WorkRunner {
    public static void main(String[] args) {
        Job job = new Job();
        job.doingJob();
        Plan plan = new Plan();
        plan.startTrip();
        Navigator navigator = new Navigator();
        navigator.doJob(plan);

        plan.finishTrip();
        navigator.doJob(plan);
    }
}
