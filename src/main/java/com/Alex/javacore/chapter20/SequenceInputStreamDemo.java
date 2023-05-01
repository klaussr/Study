package com.Alex.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;
    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }
    public FileInputStream  nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        }
        catch (IOException e) {
            return null;
        }
    }
}
public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<String>();
        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        try (SequenceInputStream input = new SequenceInputStream(ise)){
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Ошибка открытия файла");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
