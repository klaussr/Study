package com.Alex.javacore.chapter20;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Ниже приведены некоторые числовые значения в разных форматах\n");
        System.out.print("Разные целочисленные форматы: ");
        System.out.printf("%d % (d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf( "Формат чисел с плавающей точкой " + " по умолчанию: %f\n", 1234567.123);
        System.out.printf("Формат чисел с плавающей точкой, разделяемых запятыми  %,f\n", 1234567.123);
        System.out.printf("Формат отрицательных чисел с плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf("Другой формат отрицательных чисел с плавающей точкой: %,(f", -1234567.123);
        System.out.println();
        System.out.print("Выравнивание положительных и отрицательных числовых значений:\n");
        System.out.print("% ,.2f\n% ,.2f\n");
    }
}
