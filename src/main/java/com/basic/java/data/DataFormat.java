package com.basic.java.data;

import java.text.DecimalFormat;

public class DataFormat {
    public static void main(String[] args) {
        double srcData = 3.4683;
        DecimalFormat fmt = new DecimalFormat("##0.00");
        String strData = fmt.format(srcData);
        double data = Double.valueOf(strData);
        System.out.println(data);
    }
}
