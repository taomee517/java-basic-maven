package com.basic.java.effictivejava.pojo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BuilderModel {
    private int age = 3;
    private String name = "Builer模式";

    public void intro(){
        System.out.println("My name is " + name + ", and I'm " + age + " years old!");
    }
}
