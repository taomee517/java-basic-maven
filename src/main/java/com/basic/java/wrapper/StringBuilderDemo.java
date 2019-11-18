package com.basic.java.wrapper;

/**
 * StringBuilder练习
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 15:46
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(char i='a';i<='z';i++){
            sb.append(i);
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(6,'@');
        System.out.println(sb);
        sb.insert(9,'中');
        System.out.println(sb);
        sb.delete(9,13);
        System.out.println(sb);
    }
}
