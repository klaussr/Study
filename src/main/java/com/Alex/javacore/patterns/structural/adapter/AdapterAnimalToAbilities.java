package com.Alex.javacore.patterns.structural.adapter;

public class AdapterAnimalToAbilities extends Animal implements Abilities {
    @Override
    public void swimming() {
        swim();
    }

    @Override
    public void moving() {
        move();
    }

    @Override
    public void flying() {
        fly();
    }
}
