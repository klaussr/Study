package com.Alex.javacore.patterns.creational.Singleton;

public class Flower {
    private static Flower name;
    private static String listFlowers = "This is list\n";

    public static Flower getName() {
        if (name == null) {
            name = new Flower();
        }
        return name;
    }

    private Flower(){}

    public void addNewFlower(String flower){
        listFlowers += flower + "\n";
    }

    public void showList() {
        System.out.println(listFlowers);
    }
}
