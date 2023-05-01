package com.Alex.javacore.chapter21;

import org.omg.CORBA.portable.OutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        try (BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(Paths.get("test1.txt")))) {
            for (int i = 0; i < 26; i++) {
                os.write((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path error" + e);
            return;
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
