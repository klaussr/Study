package com.Alex.javacore.patterns.creational.factory;

public class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build car");
    }
}
