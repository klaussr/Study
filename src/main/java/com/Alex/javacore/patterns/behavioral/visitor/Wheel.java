package com.Alex.javacore.patterns.behavioral.visitor;

public class Wheel implements Car{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
