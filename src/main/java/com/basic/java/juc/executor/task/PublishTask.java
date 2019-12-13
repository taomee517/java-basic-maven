package com.basic.java.juc.executor.task;

import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Data
@Slf4j
public class PublishTask implements Runnable, TimerTask {
    private String imei;
    private CountDownLatch latch;

    public PublishTask(String imei,CountDownLatch latch) {
        this.imei = imei;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(51);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务发布成功, imei = {}", imei);
        latch.countDown();
    }

    @Override
    public void run(Timeout timeout) throws Exception {
        run();
    }
}
