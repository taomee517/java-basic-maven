package com.basic.java.container;

import java.util.Arrays;
import java.util.List;

public class CollectionEqual {
    public static void main(String[] args) {
        List<String> a = Arrays.asList("A", "B");
        List<String> b = Arrays.asList("A", "B", "C");
        System.out.println(a.equals(b));
        System.out.println(a.containsAll(b));
    }
}
