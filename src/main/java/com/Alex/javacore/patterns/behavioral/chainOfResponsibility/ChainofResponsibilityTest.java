package com.Alex.javacore.patterns.behavioral.chainOfResponsibility;

public class ChainofResponsibilityTest {//тест
    public static void main(String[] args) {
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext(payPalPayment);
        visaPayment.pay();
        payPalPayment.setNext(visaPayment);
        payPalPayment.pay();

    }
}
