package com.Alex.javacore.patterns.creational.factory;

public class VehicleRunner {
    public static void main(String[] args) {
        MotorVehicleFactory motorVehicleFactory = new MotorVehicleFactory();
        MotorVehicle motorVehicle = motorVehicleFactory.createVehicle("Motorcycle");
        MotorVehicle motorVehicle1 = motorVehicleFactory.createVehicle("Car");
        motorVehicle.build();
        motorVehicle1.build();
    }
}
