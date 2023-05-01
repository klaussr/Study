package com.Alex.javacore.chapter15;

interface MyFunc4 {
    MyClass1 func(int n);
}
class MyClass1 {
    private int val;
    MyClass1(int v){
        val = v;
    }
    MyClass1() {val = 0;}
    int getVal() {return val;}
}
public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc4 MyClassCons = MyClass1::new;
        MyClass1 ms = MyClassCons.func(100);
        System.out.println("Значение val в объекте ms равно: " + ms.getVal());
    }
}
