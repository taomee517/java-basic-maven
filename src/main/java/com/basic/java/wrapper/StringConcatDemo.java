package com.basic.java.wrapper;

/**
 * StringBuilder练习
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\2 0002 15:46
 */
public class StringConcatDemo {
    public static void main(String[] args) {
        String str = "$start";
        long mem1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            str += i;
        }
        long mem2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String累加消耗内存：" + (mem2 - mem1));
        System.out.println("String累加花费时间：" + (time2 - time1));

        StringBuilder sb = new StringBuilder("$start");
        long mema = Runtime.getRuntime().freeMemory();
        long timea = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            sb.append(i);
        }
        long memb = Runtime.getRuntime().freeMemory();
        long timeb = System.currentTimeMillis();
        System.out.println("StringBuilder累加消耗内存：" + (memb - mema));
        System.out.println("StringBuilder累加花费时间：" + (timeb - timea));

    }
}
