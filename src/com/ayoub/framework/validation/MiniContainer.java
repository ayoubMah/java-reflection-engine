package com.ayoub.framework.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MiniContainer {

    public Object getBean() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> myClass = BeanDefinition.class;
        Constructor<?> constructor = myClass.getDeclaredConstructor();
        Object object  = constructor.newInstance();
        return object;
    }
}
