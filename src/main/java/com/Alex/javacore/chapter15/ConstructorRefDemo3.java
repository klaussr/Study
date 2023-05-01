package com.Alex.javacore.chapter15;

interface MyFunc6<R, T> {
    R func(T n);
}
class MyClass6<T> {
    private T val;
    MyClass6(T v) {
        val = v;
    }
    MyClass6() {
        val = null;
    }
    T getVal() {
        return val;
    }
}

class MyClass7 {
    String str;
    MyClass7(String s) {
        str = s;
    }
    MyClass7() {
        str = "";
    }
    String getVal() {
        return str;
    }
}
class MyClass8 {
    int F;
    MyClass8(int b) {
        F = b;
    }
    MyClass8() {
        F = 0;
    }
    int getVal() {
        return F;
    }
}
public class ConstructorRefDemo3 {
    static <R, T> R MyClassFactory(MyFunc6<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc6<MyClass6<Double>,Double> myClassCons = MyClass6<Double>::new;
        MyClass6<Double> ms = MyClassFactory(myClassCons, 100.1);
        System.out.println("Значение val в объекте ms равно " + ms.getVal());
        MyFunc6<MyClass7, String> myClassCons2 = MyClass7::new;
        MyClass7 ms2 = MyClassFactory(myClassCons2, "Лямбда");
        System.out.println("Значение str в объекте ms равно " + ms2.getVal());
        MyFunc6<MyClass8, Integer> myClassCons3 = MyClass8::new;
        MyClass8 ms3 = MyClassFactory(myClassCons3, 101);
        System.out.println("Значение F в объекте ms равно " + ms3.getVal());
    }
}
