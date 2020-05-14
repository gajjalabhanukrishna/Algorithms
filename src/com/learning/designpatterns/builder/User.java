package com.learning.designpatterns.builder;

public class User {

    private String lastName;
    private String description;
    private int age;
    private String firstName;

    public User(Builder builder){
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.description = builder.description;
        this.age = builder.age;
    }

    public static class Builder{

        private String lastName;
        private String description;
        private int age;
        private String firstName;

        public Builder(){

        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }

    public String toString(){
        return "First Name : " + this.firstName + "\n"+
                "Last Name : " + this.lastName +"\n"+
                "Age : " + this.age +"\n"+
                "Description : " + this.description;
    }
}
