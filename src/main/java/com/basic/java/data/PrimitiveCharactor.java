package com.basic.java.data;

public class PrimitiveCharactor {
    public static void main(String[] args) {
        /** char
         *  用单引号包裹
         *  占2个字节
         *  可表示65536个字符
         */
        char a = '男';
        char b = 'A';
        char c = '\u0073';

        System.out.println(c);

        /** 特殊字符须用'\'来转义 */
        char enter = '\n';
        char tab = '\t';
        System.out.println("" + a + tab  + b + c);
    }
}
