package com.Alex.javacore.patterns.behavioral.visitor;



public interface Visitor {
    void visit(SportCar sportCar);
    void visit(Engine engine);
    void visit(Wheel wheel);
}
