package com.Alex.javacore.patterns.structural.composite;

public class Race {
    public static void main(String[] args) {
        Team team = new Team();

        Racer racer1 = new Racer();
        Navigator navigator1 = new Navigator();
        Racer racer2 = new Racer();
        Navigator navigator2 = new Navigator();

        team.addSportsman(racer1);
        team.addSportsman(navigator1);
        team.addSportsman(racer2);
        team.addSportsman(navigator2);

        team.createRace();
    }
}
