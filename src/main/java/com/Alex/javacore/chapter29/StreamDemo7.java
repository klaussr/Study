package com.Alex.javacore.chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail1 {
    String name;
    String phonenum;
    String email;

    public NamePhoneEmail1(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone1 {
    String name;
    String phonenum;

    public NamePhone1(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}
public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "klsdfs@gmail.com"));
        myList.add(new NamePhoneEmail("James", "555-5554", "qwes@gmail.com"));
        myList.add(new NamePhoneEmail("Olga", "355-5555", "poiu@gmail.com"));

        Stream<NamePhone1> nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phonenum));
        List<NamePhone1> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Имена и номера телефонов в списке List ");
        for (NamePhone1 a : npList) {
            System.out.println(a.name + " " + a.phonenum);
        }
        nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phonenum));
        Set<NamePhone1> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nИмена и номера телефонов в множестве типа Set");
        for (NamePhone1 a : npSet) {
            System.out.println(a.name + " " + a.phonenum);
        }
    }
}
