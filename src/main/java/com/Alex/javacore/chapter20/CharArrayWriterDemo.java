package com.Alex.javacore.chapter20;

import java.io.IOException;
import java.io.*;

public class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны быть выведены в массив";
        char[] buff = new char[s.length()];
        s.getChars(0,s.length(), buff, 0);

        try {
            f.write(buff);
        }
        catch (IOException e) {
            System.out.println("Ошибка записи в буфер");
            return;
        }
        System.out.println("Буфер в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");

        char[] c = f.toCharArray();

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println("\nВ поток вывода типа FileWriter()");

        try (FileWriter f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        System.out.println("Установка в исходное состояние");
        f.reset();
        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
