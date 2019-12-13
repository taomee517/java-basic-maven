package com.basic.java.juc.executor.schedule;

import com.basic.java.juc.executor.task.PublishTask;
import com.basic.java.util.ZeroFillStrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduleTest {
    public static void main(String[] args) throws Exception{
        int concurretSize = 1000;
//        int threadSize = 100;
        int threadSize = Runtime.getRuntime().availableProcessors() * 2;
        CountDownLatch latch = new CountDownLatch(concurretSize);
        ScheduledThreadPoolExecutor schedulePool = new ScheduledThreadPoolExecutor(threadSize);
        long start = System.currentTimeMillis();
        for (int i=0; i<concurretSize; i++) {
            PublishTask task = new PublishTask("IMEI8" + ZeroFillStrUtil.zeroFillStr(i,4),latch);
            schedulePool.schedule(task,1000,TimeUnit.MILLISECONDS);
        }
        latch.await();
        long end = System.currentTimeMillis();
        long duration = end - start;
        log.info("线程数为：{}时，并发任务量为：{}，最大延迟时间：{} ms", threadSize, concurretSize, duration);
        schedulePool.shutdown();
    }
}
