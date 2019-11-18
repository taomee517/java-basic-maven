package com.basic.java.wrapper;

/**
 * 测试自动装箱，拆箱
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 14:49
 */
public class AutoBox {
    public static void main(String[] args) {
        /** 实际运行代码：Integer a = Integer.valueOf(123); */
        Integer a = 123;
        /** 实际运行代码：int b = a.intValue(); */
        int b = a;
        /** 实际运行代码：double c = a.doubleValue(); */
        double c = a;

        byte d = a.byteValue();

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        /**
         *      public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         *     Integer的自动装箱是调用了valueOf方法;
         *     如果数值在-128~127范围内是从Integer.cache中取值;
         *     Integer.cache中缓存了-128~127范围内的所有Integer对象
         *     如果数值不在缓存范围内，则重新new Integer对象；
         *     因此 ic != id;
         */
        Integer ia = Integer.valueOf(23);
        Integer ib = 23;
        System.out.println(ia == ib);
        System.out.println(ia.equals(ib));

        Integer ic = Integer.valueOf(1023);
        Integer id = 1023;
        System.out.println(ic == id);
        System.out.println(ic.equals(id));
        System.out.println(System.getenv().get("OS"));
    }


}
