package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(18);
        myList.add(28);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);
        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) System.out.println("Минимальное значение: " + minVal.get());
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) System.out.println("Максимальное значение: " + maxVal.get());

        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.print("Отсортированный поток данных ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        Stream<Integer> oddSorted = myList.stream().sorted().filter((n) -> ((n % 2) == 1));
        System.out.print("Нечетные значения ");
        oddSorted.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        oddSorted = myList.stream().sorted().filter((n) -> (n % 2) == 1).filter((n) -> (n > 5));
        System.out.print("Нечетные значения больше 5: ");
        oddSorted.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
