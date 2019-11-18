package com.basic.java.juc;

import java.util.concurrent.*;

/**
 * 线程池实用案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\11 0011 17:12
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CallDemo call = new CallDemo();
        Future<Integer> future = pool.submit(call);
        System.out.println(future.get());
        pool.shutdown();
    }
}

class CallDemo implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum += i;
        }
        return sum;
    }
}