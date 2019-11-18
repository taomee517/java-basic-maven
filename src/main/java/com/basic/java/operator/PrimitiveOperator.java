package com.basic.java.operator;

public class PrimitiveOperator {
    public static void main(String[] args) {
        /**
         * 不同数据类型的数据参与运算，结果为容量最大的类型
         */
        int a = 1;
        float b = 3.14f;
        double d = 6.879;
        double c = d - a - b;
        System.out.println(c);

        int x = 6;
        int y = x++;
        int n = 6;
        int z = ++n;
        System.out.println("N++，先赋值，再自增：" + y);
        System.out.println("++N，先自增，再赋值：" +z);

    }
}
