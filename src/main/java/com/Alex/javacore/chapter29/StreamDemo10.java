package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Ипсилон");
        myList.add("Дзета");

        Stream<String> myStream = myList.stream();
        Spliterator<String> spliterator = myStream.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        if (spliterator1 != null) {
            System.out.println("Результат, выводимый итератором spliterator1 ");
            spliterator1.forEachRemaining(System.out::println);
        }
        System.out.println("Результат, выводимый итератором spliterator ");
        spliterator.forEachRemaining(System.out::println);
    }
}
