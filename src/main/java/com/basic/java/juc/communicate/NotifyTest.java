package com.basic.java.juc.communicate;

public class NotifyTest implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end!");
    }


    public static void main(String[] args) {
        NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++){
            new Thread(test).start();
        }

        synchronized (test) {
            test.notify();
        }

        try {
            Thread.sleep(3000);
            System.out.println("-----------分割线-------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (test) {
            test.notifyAll();
        }
    }
}