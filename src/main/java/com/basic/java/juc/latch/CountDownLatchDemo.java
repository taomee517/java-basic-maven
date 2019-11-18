package com.basic.java.multithread.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/5
 * @time 18:59
 *
 * @Desc 目标是想唤醒主线程，但是失败了！以后可以再完善
 */
public class CountDownLatchDemo {
    CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.listener();
    }

    public void listener() throws Exception{
        System.out.println(Thread.currentThread() + "开始");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "等待5秒！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        latch.await();
        System.out.println(Thread.currentThread() + "被唤醒");
    }
}
