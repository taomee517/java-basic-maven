package com.basic.java.designmode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/14
 * @time 15:05
 */
public class DesignModeDemo {
    public static void main(String[] args) {
        int value = new Random().nextInt(2000);
        System.out.println("初始参数为：" + value);
        MyHandlerChain handlerChain = new MyHandlerChain();
        handlerChain.creatHandlerChain();
        handlerChain.setMethod(new RealMethod());
        handlerChain.doHandle(value);
    }
}

interface HandlerChain{
    public void creatHandlerChain();
    public void doHandle(int i);
}

class MyHandlerChain implements HandlerChain{
    private int pos = 0;
    private int chainSize = 4;
    List<Handler> handlerChain = new ArrayList<>();
    private RealMethod method;


    @Override
    public void creatHandlerChain() {
        PlusHandler plusHandler = new PlusHandler();
        MinusHandler minusHandler = new MinusHandler();
        MultiHandler multiHandler = new MultiHandler();
        DivisionHandler divisionHandler = new DivisionHandler();
        handlerChain.add(minusHandler);
        handlerChain.add(divisionHandler);
        handlerChain.add(plusHandler);
        handlerChain.add(multiHandler);
    }

    @Override
    public void doHandle(int value) {
        if(pos<chainSize){
            Handler handler = handlerChain.get(pos);
            int newVal = handler.handle(value);
            pos++;
            System.out.println("经过" + handler.getClass().getName() + "处理后的值为：" + newVal);
            this.doHandle(newVal);
        }else{
            method.show(value);
        }
    }

    public int getChainSize() {
        return chainSize;
    }

    public void setChainSize(int chainSize) {
        this.chainSize = chainSize;
    }

    public RealMethod getMethod() {
        return method;
    }

    public void setMethod(RealMethod method) {
        this.method = method;
    }
}

class RealMethod{
    public void show(int value){
        System.out.println("经过一系列处理后的值为：" + value);
    }
}

interface Handler{
    int handle(int value);
}

class PlusHandler implements Handler{
    @Override
    public int handle(int value) {
        value += 1;
        return value;
    }
}

class  MinusHandler implements Handler{
    @Override
    public int handle(int value) {
        value -= 2;
        return value;
    }
}

class  MultiHandler implements Handler{
    @Override
    public int handle(int value) {
        value = 3 * value;
        return value;
    }
}

class  DivisionHandler implements Handler{
    @Override
    public int handle(int value) {
        value = value/4;
        return value;
    }
}
