package com.Alex.javacore.chapter15;

interface StringFunc1 {
    String func(String str);
}
public class LambdaAsArgumentsDemo {
    static String stringOp(StringFunc1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка " + inStr);
        outStr = stringOp(String::toUpperCase, inStr);
        System.out.println("Это строка в верхнем регистре " + outStr);

        outStr = stringOp(str -> {
            String result = "";
            int j;

            for (int i = 0; i < str.length()-1; i++) {
                if (str.charAt(i) != ' ')
                result += str.charAt(i);
            }
            return result;
        }, inStr);
        System.out.println("Это строка с удаленными пробелами " + outStr);

        StringFunc1 reverse = (str) -> {
            String result = "";
            int j;

            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println(stringOp(reverse, inStr));
    }
}
