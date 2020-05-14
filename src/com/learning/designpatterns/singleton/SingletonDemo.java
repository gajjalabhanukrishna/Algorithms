package com.learning.designpatterns.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();

        if(s ==s1){
            System.out.println(s);
            System.out.println(s1);
        }

    }
}
