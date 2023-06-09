package com.Alex.javacore.chapter15;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
    private int val;
    MyClass(int v) {
        val = v;
    }
    int getVal() {
        return val;
    }
}
public class UseMethodRef {
    static int compareMS(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> al = new ArrayList<MyClass>();
        al.add(new MyClass(1));
        al.add(new MyClass(2));
        al.add(new MyClass(3));
        al.add(new MyClass(4));
        al.add(new MyClass(5));
        al.add(new MyClass(6));

        MyClass maxVal = Collections.max(al, UseMethodRef::compareMS);
        System.out.println("Максимальное значение равно " + maxVal.getVal());
    }
}
