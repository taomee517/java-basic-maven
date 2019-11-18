package com.basic.java.math;

import java.util.Map;
import java.util.Random;

/**
 * 数学类，Random类案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 16:34
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println("------------------Math类常用方法------------------");
        /**向上取整*/
        System.out.println(Math.ceil(3.2));
        /**向下取整*/
        System.out.println(Math.floor(3.2));
        /**四舍五入*/
        System.out.println(Math.round(3.2));
        System.out.println(Math.round(3.8));
        /**取平方根*/
        System.out.println(Math.sqrt(64));
        /**求幂*/
        System.out.println(Math.pow(2,5));
        System.out.println(Math.pow(5,2));
        /**圆周率*/
        System.out.println(Math.PI);
        /**自然常数E*/
        System.out.println(Math.E);
        /**0~1的随机小数*/
        System.out.println(Math.random());

        System.out.println("---------------------随机数---------------------");

        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextDouble());
        System.out.println(random.nextBoolean());
        /**生成0~10的整数*/
        System.out.println(random.nextInt(10));
        /**生成20~30的整数*/
        System.out.println(20 + random.nextInt(10));
        /**生成20~30的小数*/
        System.out.println(20 + random.nextDouble()*10);
    }
}
