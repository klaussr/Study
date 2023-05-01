package com.Alex.javacore.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUrlDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) hp.openConnection();

        System.out.println("Метод запроса: " + httpURLConnection.getRequestMethod());
        System.out.println("Код ответа: " + httpURLConnection.getResponseCode());
        System.out.println("Код ответа: " + httpURLConnection.getResponseMessage());
        Map<String, List<String>> hMap = httpURLConnection.getHeaderFields();
        Set<String> hSet = hMap.keySet();
        System.out.println("\nДалее следует заголовок");

        for (String k : hSet) {
            System.out.println("Ключ " + k + ", значение " + hMap.get(k));
        }

    }
}
