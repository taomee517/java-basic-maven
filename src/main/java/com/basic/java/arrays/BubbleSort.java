package com.basic.java.arrays;

import java.util.Arrays;

/**
 * 数组的冒泡排序
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 12:55
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrays = {3,4,6,8,0,9,1,7,2,5};
        int temp = 0;
        for(int i=0;i<arrays.length-1;i++){
            boolean flag = true;
            for (int j=0;j<arrays.length-1-i;j++){
                if(arrays[j]>arrays[j+1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(arrays));
            }
            System.out.println("--------------------------------");
            if(flag){
                System.out.println("完成排序");
                break;
            }
        }
    }
}
