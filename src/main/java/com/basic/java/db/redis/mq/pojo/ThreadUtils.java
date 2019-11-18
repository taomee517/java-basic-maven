package com.basic.java.db.redis.mq.pojo;

import javax.sound.midi.Soundbank;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/16
 * @time 15:45
 */
public class ThreadUtils {
    public static void killThread(String threadName){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread thread:threads) {
            if (thread != null && threadName.equals(thread.getName())) {
                thread.interrupt();
            }
        }
    }

    public static void killThreads(String pattern){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread thread:threads) {
            if (thread != null && thread.getName().startsWith(pattern)) {
                thread.interrupt();
            }
        }
    }

    public static void killLastThreads(String pattern,int limit){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for (Thread thread:threads) {
            String threadName = thread.getName();
            if (thread != null && threadName.startsWith(pattern)) {
                int index = Integer.valueOf(threadName.substring(threadName.lastIndexOf('_')+1));
                if(index<limit){
                    thread.interrupt();
                }
            }
        }
    }

    public static void threadShow(){
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        for(Thread thread:threads){
            System.out.println(thread.getName());
        }
    }


    public static void main(String[] args) throws Exception{
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run(){
                    try {
                        Thread.sleep(2000000);
                    }catch (Exception e){

                    }

                }
            },"thread" + i).start();
        }
        System.out.println("—————kill前—————");
        threadShow();
        Thread.sleep(1000);
        killThread("thread3");
        System.out.println("—————kill后—————");
        Thread.sleep(1000);
        threadShow();

    }
}
