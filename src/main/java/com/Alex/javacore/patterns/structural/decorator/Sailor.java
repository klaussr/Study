package com.Alex.javacore.patterns.structural.decorator;

public class Sailor implements Worker{
    @Override
    public String doingJob() {
        return "I pull the anchor\n";
    }
}
