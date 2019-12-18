package com.basic.java.juc.executor.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class RejectExceptionTest {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("任务被取消");
                log.info("任务：{}",r);
                log.info("线程池对象：{}",executor);
            }
        });
        for(int i=0;i<15;i++){
            final int index = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务：" + index);
                    log.info("线程池：{}", pool);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
