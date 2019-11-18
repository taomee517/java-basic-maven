package com.basic.java.hashmap;

import com.basic.java.util.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap示例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\3 0003 12:14
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        Employee e1 = new Employee(1001,"龙飞",8846);
        Employee e2 = new Employee(1002,"张奇峰",12000);
        Employee e3 = new Employee(1003,"王昆",9612);
        map.put(e1.getId(),e1);
        map.put(e2.getId(),e2);
        map.put(e3.getId(),e3);
        System.out.println(map.get(1001));
        System.out.println(map.hashCode());
        System.out.println(map);
    }
}
