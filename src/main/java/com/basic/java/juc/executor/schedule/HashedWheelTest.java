package com.basic.java.juc.executor.schedule;

import com.basic.java.juc.executor.task.PublishTask;
import com.basic.java.util.ZeroFillStrUtil;
import io.netty.util.HashedWheelTimer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HashedWheelTest {
    public static void main(String[] args) throws Exception{
        int concurretSize = 1000;
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(concurretSize);
        //创建Timer, 精度为100毫秒,
        HashedWheelTimer timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        for (int i=0; i<concurretSize; i++) {
            PublishTask task = new PublishTask("IMEI8" + ZeroFillStrUtil.zeroFillStr(i,4),latch);
            timer.newTimeout(task,1000,TimeUnit.MILLISECONDS);
        }
        latch.await();
        long end = System.currentTimeMillis();
        long duration = end - start;
        log.info("Bucket：{}时，并发任务量为：{}，最大延迟时间：{} ms",512, concurretSize, duration);
        timer.stop();
    }
}
