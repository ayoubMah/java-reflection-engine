package com.ayoub.framework.validation;

public class OrderService {

    @Autowired
    private PaymentProcess payment;

    // no need the constructor java provides a default empty one


    public void checkout() {
        payment.pay(100.00);
    }
}
