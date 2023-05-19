package com.Alex.javacore.patterns.creational.Singleton;

public class Runner {
    public static void main(String[] args) {
        Flower.getName().addNewFlower("Tulip");
        Flower.getName().addNewFlower("Astra");
        Flower.getName().addNewFlower("Rose");

        Flower.getName().showList();
    }

}
