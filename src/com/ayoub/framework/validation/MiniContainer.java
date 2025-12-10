package com.ayoub.framework.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MiniContainer {
    BeanDefinition config = new BeanDefinition();
    Map<Class<?>, Object> singletonObjects = new HashMap<>();

    public Object getBean(Class<?> interfaceClass) {

        //check the cache first
        if (singletonObjects.containsKey(interfaceClass)){
            return singletonObjects.get(interfaceClass);
        }

        Class<?> implClass = config.beanMapping.get(interfaceClass);

        if (implClass == null) {
            throw new RuntimeException("No bean definition for: " + interfaceClass.getName());
        }

        // create the instance
        Object object;
        try {
            Constructor<?> constructor = implClass.getDeclaredConstructor();
            object = constructor.newInstance();
            injectDependencies(object);
            singletonObjects.put(interfaceClass, object);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create bean: " + implClass.getName(), e);
        }
        return object;
    }

    private void injectDependencies(Object objectInstance) {
        // get the class of the objInstance
        Class<?> cl = objectInstance.getClass();

        // get all fields
        Field fieldList[] = cl.getDeclaredFields();
        for (Field field : fieldList){
            if (field.isAnnotationPresent(Autowired.class)){
                // the magic
                Object dependency = getBean(field.getType());
                field.setAccessible(true); // even it's private i can inject
                try {
                    field.set(objectInstance, dependency);
                }catch (IllegalAccessException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
