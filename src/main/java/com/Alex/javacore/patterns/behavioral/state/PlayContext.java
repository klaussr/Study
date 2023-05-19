package com.Alex.javacore.patterns.behavioral.state;

public class PlayContext implements State{
    private State state;
    public void setState(State state){
        this.state = state;
    }
    public void doAction() {
        this.state.doAction();
    }
}
