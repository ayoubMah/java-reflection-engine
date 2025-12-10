package com.ayoub.framework.validation;

import java.lang.reflect.Constructor;

public class MiniContainer {
    BeanDefinition config = new BeanDefinition();

    public Object getBean(Class<?> interfaceClass) {
        Class<?> myClass = config.beanMapping.get(interfaceClass); // so when we did map.get(key) we get the value: in this case it's paypal

        if (myClass == null) {
            throw new RuntimeException("Bean not found!");
        }
        Object object;
        try {
            Constructor<?> constructor = myClass.getDeclaredConstructor();
            object = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
