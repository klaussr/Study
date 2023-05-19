package com.Alex.javacore.patterns.behavioral.observer;

public class ObserverTest {
    public static void main(String[] args) {
        University university = new University();
        Director director = new Director();
        university.addStudent("Vaska");
        university.addObserver(director);
        university.addStudent("Anna");
        university.removeStudent("Vaska");
    }
}
