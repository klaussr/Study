package com.Alex.javacore.patterns.creational.factory;

public class Motorcycle implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build motorcycle");
    }
}
