package com.Alex.javacore.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Sportsman> sportsmen = new ArrayList<Sportsman>();

    public void addSportsman(Sportsman sportsman) {
        sportsmen.add(sportsman);
    }

    public void removeSportsman(Sportsman sportsman) {
        sportsmen.remove(sportsman);
    }

    public void createRace() {
        System.out.println("Team prepared to the race");
        for (Sportsman sportsman : sportsmen) {
            sportsman.actingCompetition();
        }
    }
}
