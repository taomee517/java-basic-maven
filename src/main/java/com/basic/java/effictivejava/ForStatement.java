package com.basic.java.effictivejava;

import com.basic.java.effictivejava.pojo.BuilderModel;

import java.util.Arrays;
import java.util.List;

public class ForStatement {
    public static void main(String[] args) {
        BuilderModel model1 = BuilderModel.builder().age(12).name("Jam").build();
        BuilderModel model2 = BuilderModel.builder().age(8).name("March").build();
        List<BuilderModel> models = Arrays.asList(model1,model2);

        //不要直接使用i<models.size()
        for(int i=0,n=models.size();i<n;i++){
            System.out.println(models.get(i).getName());
        }
    }
}
