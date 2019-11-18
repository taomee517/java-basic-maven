package com.basic.java.container;

import java.util.ArrayList;
import java.util.List;

public class ForNewTest {
    public static void main(String[] args) {
        List<EntiDemo> entis = new ArrayList<>();
        EntiDemo enti = null;
        for(int i = 0; i< 10; i++){
            enti = new EntiDemo();
            enti.setAge(i);
            enti.setName("demo" + i);
            entis.add(enti);
        }
        System.out.println(entis);
    }
}
