package com.basic.java.effictivejava;

import com.basic.java.effictivejava.pojo.BuilderModel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        BuilderModel model1 = BuilderModel.builder().age(12).name("Jam").build();
        BuilderModel model2 = BuilderModel.builder().age(8).name("March").build();
        List<BuilderModel> models = Arrays.asList(model1,model2);

//        //Lambda 表达式形式
//        Comparator<BuilderModel> c = (p1, p2) -> p1.getAge().compareTo(p2.getAge());
//
//        //方法引用 优先用方法引用
//        Comparator c1 = Comparator.comparing(BuilderModel::getAge);

        //年龄由小到大排列
        models.sort(Comparator.comparingInt(BuilderModel::getAge));
        System.out.println(models.get(0).getName());

    }

}
