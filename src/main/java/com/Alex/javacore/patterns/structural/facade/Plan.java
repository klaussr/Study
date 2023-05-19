package com.Alex.javacore.patterns.structural.facade;

public class Plan {
    private boolean activeTrip;

    public boolean isActiveTrip() {
        return activeTrip;
    }

    public void startTrip() {
        System.out.println("Trip is active");
        activeTrip = true;
    }

    public void finishTrip() {
        System.out.println("Trip is finished");
        activeTrip = false;
    }
}
