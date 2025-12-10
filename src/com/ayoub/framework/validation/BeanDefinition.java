package com.ayoub.framework.validation;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinition {
    Map<Class<?>, Class<?>> beanMapping = new HashMap<>();

    public BeanDefinition(){
        beanMapping.put(PaymentProcess.class, PaypalService.class);
    }
}
