package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
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
        while (spliterator.tryAdvance(System.out::println));
    }
}
