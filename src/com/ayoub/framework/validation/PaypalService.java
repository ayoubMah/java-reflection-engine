package com.ayoub.framework.validation;

public class PaypalService implements PaymentProcess {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " € using PayPal");
    }
}

