package com.Alex.javacore.patterns.behavioral.chainOfResponsibility;

interface Payment {
    void setNext(Payment payment);
    void pay();
}
