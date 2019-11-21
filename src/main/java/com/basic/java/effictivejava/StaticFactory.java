package com.basic.java.effictivejava;

import com.basic.java.effictivejava.pojo.HungryModel;
import com.basic.java.effictivejava.pojo.LazyModel;

public class StaticFactory {
    /**
     * 静态工厂方法比构造器优势:
     *
     * 1、静态工厂方法有名字
     * 2、静态工厂方法不必每次都创建新对象(单例模式)
     * 3、可以返回原返回类型的子类
     * 4、在创建带泛型的实例时，能使代码变的更加简洁
     *
     * 通常使用from,of,valueOf,instance,getIntance,create,newInstance等方法名来命名
     */
    public static void main(String[] args) {
        LazyModel lazyModel = LazyModel.getInstance();
        HungryModel hungryModel = HungryModel.getInstance();
        lazyModel.intro();
        hungryModel.intro();
    }
}
