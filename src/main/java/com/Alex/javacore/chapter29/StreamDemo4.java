package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(18);
        myList.add(28);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        Stream<Double> SqrtRootStrm = myList.stream().map(Math::sqrt);
        Double productOfSqrRoots = SqrtRootStrm.reduce(1.0, (a, b) -> (a * b));
        System.out.println("Произведение квадратных корней равно: " + productOfSqrRoots);

    }
}
