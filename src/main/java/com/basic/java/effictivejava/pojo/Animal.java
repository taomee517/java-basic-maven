package com.basic.java.effictivejava.pojo;


import lombok.Data;

@Data
public class Animal {
    private int age;
    private String name;

    private static Animal INSTANCE;

    public static Animal creat(AnimalEnum ae){
        if(INSTANCE == null){
            switch (ae){
                case DOG:
                    INSTANCE = Dog.builder().build();
                    break;
                case CAT:
                    INSTANCE = Cat.builder().build();
                default:
                    break;
            }
        }
        return INSTANCE;
    }

    public void intro(){
        System.out.println("It's an animal");
    }
}
