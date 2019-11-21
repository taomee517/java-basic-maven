package com.basic.java.juc.latch;

import com.basic.java.util.ThreadPoolUtil;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/5
 * @time 18:59
 *
 * @Desc 目标是想唤醒主线程，但是失败了！以后可以再完善
 */
public class CountDownLatchDemo {
    CountDownLatch latch = new CountDownLatch(10);
    public static void main(String[] args) throws Exception {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.listener();
    }

    public void listener() throws Exception{
        System.out.println(Thread.currentThread() + "开始");
        ExecutorService pool = ThreadPoolUtil.pool;
        for (int i=0;i<10;i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    int time = new Random().nextInt(10000);
                    System.out.println(Thread.currentThread() + "等待" + time + "毫秒！");
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                    System.out.println(Thread.currentThread() + "解锁");
                }
            });
        }
        latch.await();
        System.out.println(Thread.currentThread() + "被唤醒");
    }
}
