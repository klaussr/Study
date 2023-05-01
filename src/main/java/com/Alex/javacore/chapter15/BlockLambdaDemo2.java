package com.Alex.javacore.chapter15;

interface StringFunc {
    String func(String i);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = (str) -> {
            String result = "";
            int j;

            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Лямбда обращается на " + reverse.func("лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));

    }
}
