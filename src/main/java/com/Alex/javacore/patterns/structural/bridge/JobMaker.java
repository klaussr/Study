package com.Alex.javacore.patterns.structural.bridge;

public class JobMaker {
    public static void main(String[] args) {
        Job[] jobs = {
                new Digging(new Digger()),
                new Sailing(new Sailor())
        };

        for (Job job : jobs) {
            job.doingJob();
        }
    }
}
