package com.Alex.javacore.chapter15;

interface myFunc5<T> {
    int func(T[] vals, T v);
}
public class MyArrayOps {
    static <T> int countmatching(T[] vals, T v) {
        int count = 0;
        for(int i = 0; i < vals.length; i++) {
            if (vals[i] == v) count++;
        }
        return count;
    }
}
class GenericMethodRefDemo {
    static <T> int myOp(myFunc5<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }




    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6, 3};
        String[] s = {"Один", "Два", "Три", "Два"};
        int count;
        count = myOp(MyArrayOps::<Integer>countmatching, vals, 4);
        System.out.println("Массив vals содержит " + count + " числа 4");

        count = myOp(MyArrayOps::<String>countmatching, s, "Два");
        System.out.println("Массив s содержит " + count + " числа Два");
    }
    }
