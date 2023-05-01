package com.Alex.javacore.chapter15;

interface someFunc<T> {
    T func(T t);
}
public class GeneralFunctionalInterfaceDemo {
    public static void main(String[] args) {
        someFunc<String> reverse = (str) -> {
            String result = "";
            int j;

            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Лямбда обращается на " + reverse.func("лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));

        someFunc<Integer> test = (n) -> {
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
