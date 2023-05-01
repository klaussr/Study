package com.Alex.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileChannel fChan = null;
        MappedByteBuffer mbuf;
        long size;

        try {
            fis = new FileInputStream("test.txt");
            fChan = fis.getChannel();
            size = fChan.size();
            mbuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, size);
            for (int i = 0; i < size; i++) {
                System.out.print((char) mbuf.get());
            }
        } catch (
                IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        } finally {
            try {
                if (fChan != null) fChan.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия канала");
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
