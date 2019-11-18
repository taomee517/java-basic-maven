package com.basic.java.data;

public class PrimitiveInteger {
    public static void main(String[] args) {
        /**
         *  byte型
         *  占1个字节
         *  -2^7 ~  2^7
         *  -128 ~ 127
         */
        byte age = 30;

        /**
         *  char型
         *  占2个字节
         *  -2^15 ~  2^15
         *  -32768 ~ 32767
         */
        char salary = 30000;

        /**
         *  int型
         *  占4个字节
         *  -2^31 ~  2^31
         *  -约21亿~ 约21亿
         */
        int population = 1400000000;

        /**
         *  long型
         *  占8个字节
         *  -2^63 ~  2^63
         *  须以L结尾
         */
        long glabalPopulation = 7000000000L;

        /** 8进制，以0开头 */
        int e = 015;
        /** 16进制，以0x开头 */
        int f = 0x16;
        /** 2进制，以0b开头 */
        int g = 0b10101;
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}
