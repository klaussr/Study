package com.Alex.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Dirlist {
    public static void main(String[] args) {
        String dirName = "\\MyDir";

        try (DirectoryStream<Path> drst = Files.newDirectoryStream(Paths.get(dirName))){
            System.out.println("Каталог " + dirName);
            for (Path entry : drst) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attrs.isDirectory()) System.out.println("<DIR>");
                else System.out.println("       ");
                System.out.println(entry.getName(1));
            }
        }
        catch (InvalidPathException e) {
            System.out.println("Path error" + e);
            return;
        }
            catch (NotDirectoryException e) {
                System.out.println(dirName + "не является каталогом");
            }
         catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
