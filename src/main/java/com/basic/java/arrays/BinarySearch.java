package com.basic.java.arrays;

import java.util.Arrays;

/**
 * 二叉树查找实现
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 13:26
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {10,20,30,16,11,80,5,28};
        //查找之前先排序，类似于数据库的建索引
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        int value = 33;
        int index = binarySearch(ints,value);
        if(index >= 0){
            System.out.println(value + "在数组ints中的下标为：" + index);
        }else {
            System.out.println("在数组ints中没有查到：" + value);
        }
    }

    public static int binarySearch(int[] ints,int value){
        int start = 0;
        int end = ints.length-1;
        while (start<=end){
            int mid = (start + end) / 2;
            if(value == ints[mid]){
                return mid;
            }
            if(value > ints[mid]){
                start = mid + 1;
            }
            if(value < ints[mid]){
                end = mid -1;
            }
        }
        return -1;
    }
}
