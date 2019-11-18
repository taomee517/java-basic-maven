package com.basic.java.juc.atomic;

/**
 * 不安全的递增操作
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\11 0011 13:34
 */
public class UnsafeIncreamentDemo {
    public static void main(String[] args) {
        UnsafeIncreament usi = new UnsafeIncreament();
        for(int i=0;i<10;i++){
            new Thread(usi).start();
        }
    }
}

class UnsafeIncreament implements Runnable{
    private int num = 0;

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
        return num ++;
    }
}