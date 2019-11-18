package com.basic.java.data;

public class OutOfRange {
    public static void main(String[] args) {
        /** 如果月，年，世纪不用long类型,肯定会溢出*/
        String unit = " ms";
        int second = 1000;
        int minute = 60 * second;
        int hour = 60 * minute;
        long day = 24L * hour;
        long month = 30L * day;
        long year = 12L * month;
        long century = 100L * year;
        long century21 = 21L * century;
        System.out.println("1秒：" + '\t' + second + unit);
        System.out.println("1分钟：" + '\t' +  minute + unit);
        System.out.println("1小时：" + '\t' +  hour + unit);
        System.out.println("1天：" + '\t' +  day + unit);
        System.out.println("1月：" + '\t' +  month + unit);
        System.out.println("1年：" + '\t' +  year + unit);
        System.out.println("1世纪：" + '\t' +  century + unit);
        System.out.println("21世纪：" + '\t' +  century21 + unit);
    }
}
