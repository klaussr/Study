package com.Alex.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLine {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Введите строки текста");
        System.out.println("Введите 'стоп' для завершения");
        do {
            str = r.readLine();
            System.out.println(str);
        } while (!str.equals("стоп"));
    }
}
