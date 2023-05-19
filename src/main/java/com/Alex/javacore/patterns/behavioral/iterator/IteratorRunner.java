package com.Alex.javacore.patterns.behavioral.iterator;

public class IteratorRunner {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        Iterator iterator = numbers.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
