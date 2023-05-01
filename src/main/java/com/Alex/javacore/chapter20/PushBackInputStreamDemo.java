package com.Alex.javacore.chapter20;

import java.io.ByteArrayInputStream;
import java.io.*;

public class PushBackInputStreamDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0; \n";
        byte[] buff = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buff);
        int c;


        try (PushbackInputStream f = new PushbackInputStream(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = f.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            f.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }

    }
}
