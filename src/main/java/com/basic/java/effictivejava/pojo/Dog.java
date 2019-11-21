package com.basic.java.effictivejava.pojo;


import lombok.Builder;

@Builder
public class Dog extends Animal {

    @Override
    public void intro() {
        System.out.println("汪汪！");
    }
}
