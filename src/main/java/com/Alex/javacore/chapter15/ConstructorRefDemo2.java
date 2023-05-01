package com.Alex.javacore.chapter15;

interface MyFunc5<T> {
    MyClass5<T> func(T n);
}
class MyClass5<T> {
    private T val;

    MyClass5(T v) {
        val = v;
    }

    MyClass5() {
        val = null;
    }

    T getVal() {
        return val;
    }
}
    public class ConstructorRefDemo2 {
        public static void main(String[] args) {
            MyFunc5<Integer> myClassCons = MyClass5<Integer>::new;
            MyClass5<Integer> ms = myClassCons.func(100);
            System.out.println("Значение val в объекте ms равно " + ms.getVal());
        }
}
