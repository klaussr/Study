package com.Alex.javacore.chapter22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.yandex.ru");
        System.out.println(address);

        InetAddress[] inetAddresses = InetAddress.getAllByName("www.mail.ru");
        for (int i = 0; i < inetAddresses.length; i++) {
            System.out.println(inetAddresses[i]);
        }
    }
}
