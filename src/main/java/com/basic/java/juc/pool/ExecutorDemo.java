package com.basic.java.juc.pool;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/19
 * @time 12:57
 */
public class ExecutorDemo {
    public static void main(String[] args) throws Exception {
        Map<String,String> env = System.getenv();;
        for(String key:env.keySet()){
            System.out.println(key + "\t===\t" + env.get(key));
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("电脑可用处理器数目：" + availableProcessors);
        LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>(1024);
        ExecutorService executor = new ThreadPoolExecutor(3, 3,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1024));
        executor.execute(new Task1());
        Future<Boolean> future = executor.submit(new Task2());
        boolean flag = future.get();
        System.out.println("Task2执行完了吗：" + flag);
        executor.shutdown();
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println("task1");
    }
}

class Task2 implements Callable<Boolean>{
    @Override
    public Boolean call() {
        System.out.println("task2");
        return true;
    }
}
