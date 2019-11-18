package com.basic.java.arrays;

/**
 * 数组复制Demo
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 11:30
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        byte[] bytes = "Hello,World!".getBytes();
        byte[] b = new byte[10];
        System.arraycopy(bytes,6,b,5,5);
        for(byte bb:b){
            if(bb==0){
                System.out.print("*");
            }
            System.out.print((char)bb + "\t");
        }
    }
}
