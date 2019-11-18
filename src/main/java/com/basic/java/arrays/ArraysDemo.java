package com.basic.java.arrays;

import java.util.Arrays;

/**
 * 数组的一些基本操作
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 12:32
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] ints = {10,20,30,16,11,80,5,28};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        //如果能查找到指定元素，返回索引，没有的话，返回负数
        System.out.println(Arrays.binarySearch(ints,28));
    }
}
