package com.learning.designpatterns.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        User user = new User.Builder().firstName("Bhanu").lastName("Gajjala")
                .age(36).description("test").build();
        System.out.println(user);
    }
}
