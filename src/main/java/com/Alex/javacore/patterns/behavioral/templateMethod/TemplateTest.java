package com.Alex.javacore.patterns.behavioral.templateMethod;

public class TemplateTest {//тест
    public static void main(String[] args) {
        Car car1 = new FirstCar();
        car1.start();
        System.out.println();
        Car car2 = new SecondCar();
        car2.start();
    }
}
