package com.basic.java.enumclass;

public class EnumClassTest {
    public static void main(String[] args) {
        DeviceEventEnum thisEv = DeviceEventEnum.LOGIN;
        switch(thisEv){
            case BIND:
                System.out.println(1);
                break;
            case LOGIN:
                System.out.println(2);
                break;
            default:
                System.out.println(0);
                break;
        }
    }

}
