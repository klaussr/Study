package com.Alex.javacore.chapter15;

interface MyFunc {
    int func(int n);
}
public class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myLyambda = (n) -> {
            int v = num + n;
            return v;
        };
    }
}
