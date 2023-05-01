package com.Alex.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))){
            long fsize = fc.size();
            MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_ONLY,0, fsize);
            for (int i = 0; i < fsize; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }
            System.out.println();
        }
        catch (InvalidPathException e) {
            System.out.println("Path error" + e);
            return;
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
