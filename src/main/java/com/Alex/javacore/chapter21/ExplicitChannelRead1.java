package com.Alex.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelRead1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileChannel fChan = null;
        ByteBuffer mbuf;
        int count;

        try {
            fis = new FileInputStream("test1.txt");
            fChan = fis.getChannel();
            mbuf = ByteBuffer.allocate(128);
            do {
                count = fChan.read(mbuf);
                if (count != -1) {
                    mbuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mbuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
        finally {
            try {
                if (fChan != null) fChan.close();
            }
            catch (IOException e) {
                System.out.println("Ошибка закрытия канала");
            }
            try {
                if (fis != null) fis.close();
            }
            catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
