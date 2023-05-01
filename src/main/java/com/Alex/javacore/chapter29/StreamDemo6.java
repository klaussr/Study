package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(1.8);
        myList.add(28.2);
        myList.add(10.4);
        myList.add(24.5);
        myList.add(17.7);
        myList.add(5.0);

        System.out.print("Исходные значения из списка myList ");
        myList.stream().forEach((a) -> {
            System.out.print(a + " ");
        });
        System.out.println();
        IntStream cStrm = myList.stream().mapToInt((a) -> (int)Math.ceil(a));
        System.out.print("Максимально допустимые пределы значений из списка myList ");
        cStrm.forEach((a) -> {
            System.out.print(a + " ");
        });
    }
}
