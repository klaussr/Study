package com.Alex.javacore.patterns.creational.factory;

public  class MotorVehicleFactory {
    public MotorVehicle createVehicle(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        switch (name) {
            case "Car":
                return new Car();
            case "Motorcycle":
                return new Motorcycle();
            default: throw new IllegalArgumentException("Unknown name" + name);
        }

    }
}
