package com.ayoub.framework.validation.demo;

import com.ayoub.framework.validation.core.Email;
import com.ayoub.framework.validation.core.NotNull;
import com.ayoub.framework.validation.core.Range;

public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @Range(min=18, max=99, message = "Age must be between 18 and 99")
    private int age;

    @Email(message = "please enter a valid email")
    private String email;

    public User(String name, int age, String email){
        this.name= name;
        this.age  = age;
        this.email = email;
    }
}
