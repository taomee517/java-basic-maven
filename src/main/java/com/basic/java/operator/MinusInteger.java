package com.basic.java.operator;

public class MinusInteger {
    public static void main(String[] args) {
        //打印出一个负数的补码
        int a=-6;
        for(int i=0;i<32;i++){
            int t=(a & 0x80000000>>>i)>>>(31-i);
            System.out.print(t);
        }
    }
}
