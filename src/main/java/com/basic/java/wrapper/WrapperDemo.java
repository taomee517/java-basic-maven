package com.basic.java.wrapper;

import com.basic.java.innerclass.InnerClassDemo;

/**
 * 基本包装类Demo
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 14:40
 */
public class WrapperDemo {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = Integer.valueOf("38");
        Integer c = Integer.parseInt("9999");
        String str = c.toString();

        System.out.println(a);
        System.out.println(b);
        System.out.println(str);
        System.out.println("int类型的最大值是：" + Integer.MAX_VALUE);
        System.out.println("int类型的最小值是：" + Integer.MIN_VALUE);
        //Number接口的方法
        System.out.println(a.doubleValue());
        System.out.println(a.floatValue());
    }
}
