package com.basic.java.fzkutil.others;

import java.util.HashMap;
import java.util.Map;

public enum WmiEnum {
    LSV("上海大众", "上海大众"),
    LFV("一汽大众","一汽大众"),
    LSG("上海通用","上海通用"),
    LDC("东风雪铁龙","神龙汽车"),
    LEN("北京吉普","北京吉普"),
    LHG("广汽本田", "广汽本田"),
    LHB("北汽福田","北汽福田"),
    LS5("长安汽车","长安汽车"),
    LNB("北京现代", "北京现代"),
    LFP("一汽","一汽轿车"),
    LGB("东风汽车","东风汽车"),
    LDN("东南汽车","东南汽车"),

    ;


    private String brand;
    private String company;
    public static Map<String,String> WMI_BRAND_MAP = new HashMap<>();

    WmiEnum(String brand,String company){
        this.brand = brand;
        this.company = company;
    }

    public String getBrandByWmi(String wmi){
        return WMI_BRAND_MAP.get(wmi);
    }

    static {
        WmiEnum[] wmis = values();
        for(WmiEnum wmi : wmis){
            WMI_BRAND_MAP.put(wmi.name(),wmi.brand);
        }
    }
}
