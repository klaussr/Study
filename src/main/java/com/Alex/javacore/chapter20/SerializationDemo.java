package com.Alex.javacore.chapter20;

import java.io.*;

class MyClass9 implements Serializable {
    String s;
    int i;
    double d;
    MyClass9(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }
    public String toString() {
        return "s= " + s + " i= " + i + " d= " + d;
    }
}
public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass9 myObject = new MyClass9("Hello", 4, 3.0);
            System.out.println("object1 = " + myObject);
            oos.writeObject(myObject);
        }
        catch (IOException e) {
            System.out.println("Исключение при сериализации " + e);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass9 object2 = (MyClass9) ois.readObject();
            System.out.println("object2 = " + object2);
        }
        catch (Exception e) {
            System.out.println("Исключение при десериализации " + e);
            System.exit(0);
        }
    }
}
