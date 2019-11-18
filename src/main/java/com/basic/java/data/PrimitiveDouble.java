package com.basic.java.data;

import java.math.BigDecimal;

public class PrimitiveDouble {
    public static void main(String[] args) {
        /** float
         *  占4字节
         *  -3.403e38 ~ 3.403e38
         *  须以F结尾，否则小数默认为double类型
         */
        float f = 3.14F;

        /** double
         *  占8字节
         *  -1.798e308 ~ 1.798e308
         */
        double d = 6.28;

        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));

        System.out.println(bd);
        System.out.println(1.0-0.1-0.1);

        /** float类型不精确，不适用于比较 */
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        BigDecimal bd2 = BigDecimal.valueOf(1.0/10);
        boolean b = bd1.equals(bd2);
        System.out.println(b);

    }
}
