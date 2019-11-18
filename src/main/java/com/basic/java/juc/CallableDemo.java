package com.basic.java.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable实现案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\11 0011 15:30
 */
public class CallableDemo {
    public static void main(String[] args) {
        MyCall call = new MyCall();
        //1.执行Callable需要FutureTask实现类的支持，用于接收Callable执行后的返回值
        FutureTask<String> task = new FutureTask<String>(call);
        new Thread(task).start();
        try {
            //2.接收线程运算后的结果
            String status = task.get();
            System.out.println(status);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCall implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        int sum = 0 ;
        for(int i=0;i<500000;i++){
            sum += i;
            if(sum>0&&sum%1314==0){
                return "失败：" + sum + ",计算到第" + i + "位";
            }
        }
        return "成功：" + sum;
    }
}

