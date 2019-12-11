package com.basic.java.reflect;

import com.basic.java.reflect.model.CmdApi;
import com.basic.java.reflect.model.MethodEntity;
import com.basic.java.reflect.model.MethodSign;
import com.basic.java.reflect.model.ParamEntity;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MethodCollector {
    String funcA = "查询（指定标签）";
    String funcB = "查询（标签枚举）";
    String funcC = "设置主机地址";

    public static void main(String[] args) {
//        List<String> methodNames = getAllMethodNames();
//        methodNames.stream().forEach(m-> System.out.println(m));


//        List<MethodEntity> methodEntities = getAllMethod();
        List<MethodEntity> methodEntities = getAllMethodFromJavaDoc();
        methodEntities.stream().forEach(e-> System.out.println(e.getMethodName()));

//        List<Boolean> paramTypes = getParaTypeByMethodName("查询（指定标签）");
//        List<Boolean> paramTypes = getParaTypeByMethodName("查询（标签枚举）");
//        List<Boolean> paramTypes = getParaTypeByMethodName("设置主机地址");
//        paramTypes.stream().forEach(b-> System.out.println(b));
    }

    @Test
    public void  paramEntityTest(){
        List<ParamEntity> paramEntities = getParaEntityByMethodName(funcA);
        paramEntities.stream().forEach(p-> System.out.println(p.getParamDesc()));
    }

    @Test
    public void methodEntityWithJavaDoc(){
        List<MethodEntity> methodEntities = getAllMethodFromJavaDoc();
        methodEntities.stream().forEach(e-> System.out.println(e.getMethodName()));
    }

    //获取所有方法名称
    public static List<String> getAllMethodNames(){
        List<String> methodNames = null;
        Class<?> clazz = CmdApi.class;
        Method[] methods = clazz.getDeclaredMethods();
        if(methods.length>0){
            methodNames = new ArrayList<>(methods.length);
            for(Method m:methods){
                Annotation anno = m.getAnnotation(MethodSign.class);
                if (!Objects.isNull(anno)) {
                    String methodName = ((MethodSign) anno).name();
                    methodNames.add(methodName);
                }
            }
            return methodNames;
        }
        return Collections.EMPTY_LIST;
    }

    //获取所有方法对象，包含方法名及方法注解中文名
    public static List<MethodEntity> getAllMethod(){
        List<MethodEntity> methodEntities = null;
        Class<?> clazz = CmdApi.class;
        Method[] methods = clazz.getDeclaredMethods();
        if(methods.length>0){
            methodEntities = new ArrayList<>(methods.length);
            MethodEntity methodEntity = null;
            for(Method m:methods){
                Annotation anno = m.getAnnotation(MethodSign.class);
                if (!Objects.isNull(anno)) {
                    methodEntity = new MethodEntity();
                    String methodSign = ((MethodSign) anno).name();
                    methodEntity.setMethodSign(methodSign);
                    methodEntity.setMethodName(m.getName());
                    methodEntities.add(methodEntity);
                }
            }
            return methodEntities;
        }
        return Collections.EMPTY_LIST;
    }

    //从JavaDoc获取所有方法对象，包含方法名及方法注解中文名 TODO
    public static List<MethodEntity> getAllMethodFromJavaDoc(){
//        List<MethodEntity> methodEntities = null;
//        Class<?> clazz = CmdApi.class;
//        Method[] methods = clazz.getDeclaredMethods();
//        if(methods.length>0){
//            methodEntities = new ArrayList<>(methods.length);
//            MethodEntity methodEntity = null;
//            for(Method m:methods){
//                Annotation anno = m.getAnnotation(MethodSign.class);
//                if (!Objects.isNull(anno)) {
//                    methodEntity = new MethodEntity();
//                    String methodSign = ((MethodSign) anno).name();
//                    methodEntity.setMethodSign(methodSign);
//                    methodEntity.setMethodName(m.getName());
//                    methodEntities.add(methodEntity);
//                }
//            }
//            return methodEntities;
//        }
        return Collections.EMPTY_LIST;
    }

    public Method getMethodByAnnotation(String functionName){
        Class<?> clazz = CmdApi.class;
        Method[] methods = clazz.getDeclaredMethods();
        if(methods.length>0){
            for(Method m:methods){
                Annotation anno = m.getAnnotation(MethodSign.class);
                if (!Objects.isNull(anno)) {
                    String methodName = ((MethodSign) anno).name();
                    if(functionName.equals(methodName)){
                        return m;
                    }
                }
            }
        }
        return null;
    }

    //获取所有参数类型，并判断其是否枚举类
    public static List<Boolean> getParaTypeByMethodName(String functionName){
        List<Boolean> paraTypes = null;
        Class<?> clazz = CmdApi.class;
        Method[] methods = clazz.getDeclaredMethods();
        if(methods.length>0){
            for(Method m:methods){
                Annotation anno = m.getAnnotation(MethodSign.class);
                if (Objects.isNull(anno)) {
                    return Collections.EMPTY_LIST;
                }
                String methodName = ((MethodSign) anno).name();
                if(!functionName.equals(methodName)){
                    continue;
                }
                Class<?>[] paramClasses = m.getParameterTypes();

                if (paramClasses.length==0) {
                    return Collections.EMPTY_LIST;
                }

                paraTypes = new ArrayList<>();
                for (Class<?> cls : paramClasses) {
                    if(cls.isEnum()){
                        paraTypes.add(Boolean.TRUE);
                    }else {
                        paraTypes.add(Boolean.FALSE);
                    }
                }
                return paraTypes;
            }
        }
        return Collections.EMPTY_LIST;
    }

    //获取所有参数类型及名称
    public static List<ParamEntity> getParaEntityByMethodName(String functionName){
        List<ParamEntity> paramEntities = null;
        Class<?> clazz = CmdApi.class;
        Method[] methods = clazz.getDeclaredMethods();
        if(methods.length>0){
            for(Method m:methods){
                Annotation anno = m.getAnnotation(MethodSign.class);
                if (Objects.isNull(anno)) {
                    return Collections.EMPTY_LIST;
                }
                String methodName = ((MethodSign) anno).name();
                if(!functionName.equals(methodName)){
                    continue;
                }
                Class<?>[] paramClasses = m.getParameterTypes();
                Annotation[][] paramAnnos = m.getParameterAnnotations();
                if (paramClasses.length==0) {
                    return Collections.EMPTY_LIST;
                }

                paramEntities = new ArrayList<>(paramAnnos.length);
                for (int i=0;i<paramClasses.length;i++) {
                    ParamEntity paramEntity = new ParamEntity();
                    Class<?> cls = paramClasses[i];
                    if(cls.isEnum()){
                        paramEntity.setIsEnum(Boolean.TRUE);
                    }else {
                        paramEntity.setIsEnum(Boolean.FALSE);
                    }
                    String paraDesc = paramAnnos[i][0].toString();
                    String paraName = StringUtils.substringBetween(paraDesc,"=",")");
                    paramEntity.setParamDesc(paraName);
                    paramEntities.add(paramEntity);
                }
                return paramEntities;
            }
        }
        return Collections.EMPTY_LIST;
    }
}
