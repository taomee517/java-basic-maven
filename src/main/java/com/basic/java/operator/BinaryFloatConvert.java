package com.basic.java.operator;

import org.apache.commons.lang.StringUtils;

public class BinaryFloatConvert {
    public static void main(String[] args) {
        String binaryString="01000010111011010000000000000000";
        //存放结果
        double result;
        //得到符号位
        String sign = StringUtils.substring(binaryString, 0, 1);
        System.out.print("符号位:" + sign + "\t ==>\t");
        int signData = (sign.equals("1") ? -1 : 1);
        System.out.println(signData);

        //得到阶码
        String exponent = StringUtils.substring(binaryString, 1, 9 );
        System.out.print("指数部分:" + exponent + "\t ==>\t");
        //指数转换为十进制
        int expint = Integer.parseInt(exponent, 2);
        //得到实际的阶码
        int mobit = expint - 127;
        //以2为底求值
        Double d = Math.pow(2,mobit);
        System.out.println(d);

        //得到尾数
        String last = StringUtils.substring(binaryString,9);
        System.out.print("尾数部分:" + last + "\t ==>\t");
        //存放尾数的结果
        double lastRes = 0D;
        for(int i=0; i<last.length(); i++) {
            char b = last.charAt(i);
            if(b == '1') {
                //尾数的计算
                lastRes += Math.pow(2, -(i + 1));
            }
        }
        double lastData = 1 + lastRes;
        System.out.println(lastData);
        //结果=符号*指数*尾数
        result = signData * d * lastData;
        System.out.println(result);
    }

}
