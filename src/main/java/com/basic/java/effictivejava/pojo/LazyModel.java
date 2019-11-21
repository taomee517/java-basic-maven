package com.basic.java.effictivejava.pojo;

/**
 * @desc 懒汉模式
 * @author Taomee
 */
public class LazyModel {
    private static LazyModel INSTANCE ;

    private LazyModel(){}

    public static LazyModel getInstance(){
        if(INSTANCE ==null){
            INSTANCE  = new LazyModel();
        }
        return INSTANCE ;
    }

    public void intro(){
        System.out.println("懒汉模式！");
    }

}
