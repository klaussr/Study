package com.Alex.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelWrite1 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;

        try {
            fos = new FileOutputStream("test.txt");
            fChan = fos.getChannel();
            mBuf = ByteBuffer.allocate(128);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
            mBuf.rewind();
            fChan.write(mBuf);
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
                if (fos != null) fos.close();
            }
            catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
