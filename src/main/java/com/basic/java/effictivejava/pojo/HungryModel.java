package com.basic.java.effictivejava.pojo;

/**
 * @desc 懒汉模式
 * @author Taomee
 */
public class HungryModel {
    private static final HungryModel INSTANCE  = new HungryModel();

    private HungryModel(){}

    public static HungryModel getInstance(){
        return INSTANCE ;
    }

    public void intro(){
        System.out.println("饿汉模式！");
    }

}
