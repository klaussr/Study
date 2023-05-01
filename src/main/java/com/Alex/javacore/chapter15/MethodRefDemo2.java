package com.Alex.javacore.chapter15;

interface StringFunc3 {
    String func(String s);
}
class MyStringOps1 {
    String strReverse(String s) {
        String result = "";
        int i;

        for (i = s.length()-1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

class MethodRefDemo1 {
    static String StringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        MyStringOps1 ms = new MyStringOps1();

        outStr = StringOp(ms::strReverse, inStr);
        System.out.println("Исходная строка " + inStr);
        System.out.println("Обращенная строка" + outStr);
    }
}
