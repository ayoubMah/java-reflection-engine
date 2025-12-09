package com.ayoub.framework.validation;

public class OrderService {

    private final PaymentProcess payment;

    public OrderService(PaymentProcess payment) {
        this.payment = payment;
    }

    public void checkout() {
        payment.pay(100.00);
    }
}

