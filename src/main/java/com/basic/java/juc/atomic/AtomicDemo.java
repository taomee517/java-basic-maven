package com.basic.java.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS原子性操作案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\11 0011 13:19
 * @Desc JUC提供了原子性变量：
 *        1. volatile关键字保证了内存可见性
 *        2. CAS算法保证了数据的原子性
 *           CAS算法是硬件为并发操作共享数据提供的支持：
 *           CAS包含三个数据：
 *           内存值:V  预期值：A  将要更新的值：B
 *           只有当V == A 时，才将B赋值给V
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicIncreament ai = new AtomicIncreament();
        for(int i=0;i<10;i++){
            new Thread(ai).start();
        }
    }
}

class AtomicIncreament implements Runnable{
    private volatile AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + getNum());
    }

    public int getNum() {
        return num.getAndIncrement();
    }
}
