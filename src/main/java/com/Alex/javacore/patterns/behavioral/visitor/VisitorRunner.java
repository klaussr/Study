package com.Alex.javacore.patterns.behavioral.visitor;

public class VisitorRunner {
    public static void main(String[] args) {
        Car computer = new SportCar();
        computer.accept(new CarVisitor());
    }
}
