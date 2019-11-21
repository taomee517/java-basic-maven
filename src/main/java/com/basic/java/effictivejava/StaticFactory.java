package com.basic.java.effictivejava;

import com.basic.java.effictivejava.pojo.*;

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

        BuilderModel builderModel = BuilderModel.builder()
                .age(5)
                .name("Nick")
                .build();
        builderModel.intro();

        Animal dog = Animal.creat(AnimalEnum.DOG);
        dog.intro();

        //Animal采用的是单例模式，cat未被实例化，cat也是dog
        Animal cat = Animal.creat(AnimalEnum.CAT);
        cat.intro();
    }
}
