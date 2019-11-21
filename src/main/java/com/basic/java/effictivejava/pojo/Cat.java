package com.basic.java.effictivejava.pojo;

import lombok.Builder;

@Builder
public class Cat extends Animal {

    @Override
    public void intro() {
        System.out.println("喵！");
    }
}
