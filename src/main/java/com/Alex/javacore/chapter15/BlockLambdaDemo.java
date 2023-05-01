package com.Alex.javacore.chapter15;

interface NumericFunc {
    int func(int n);
}
public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc test = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        };
        System.out.println("Факториал числа 3 равен " + test.func((3)));
        System.out.println("Факториал числа 5 равен " + test.func((5)));

    }
}
