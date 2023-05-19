package com.Alex.javacore.patterns.structural.adapter;

public class AnimalRunner {
    public static void main(String[] args) {
        Abilities abilities = new AdapterAnimalToAbilities();

        abilities.swimming();
        abilities.moving();
        abilities.flying();

    }
}
