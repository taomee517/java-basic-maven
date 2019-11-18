package com.basic.java.wrapper;

/**
 * String的一些知识点
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 15:35
 */
public class StrDemo {
    public static void main(String[] args) {
        String a = "hello,";
        String b = "world";
        String c = "hello,world";
        String d = "hello," + "world";
        System.out.println(a+b == c);
        System.out.println(c == d);
        System.out.println(c.equals(a+b));

        /**StringBuilder 是线程不安全的，但是效率高
         * StringBuffer 线程安全，但效率低;
         */
        StringBuilder sb = new StringBuilder(c);
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
        sb.setCharAt(5,'@');
        System.out.println(sb);
    }
}
