package com.basic.java.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/3/25
 * @time 11:12
 */
@Slf4j
public class ThreadPoolUtil {
    public static ThreadFactory threadFactory = new CustomThread("java-basic-thread-pool");
    public static final ExecutorService pool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()*2,Runtime.getRuntime().availableProcessors()*2,0L, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1024),threadFactory);
}
