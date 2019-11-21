package com.basic.java.juc.volatilej;

import lombok.Data;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SessionTimeoutDemo {

    public static void main(String[] args) {

        while (true){
            Scanner input = new Scanner(System.in);
            String text = input.nextLine();
            TimeTask t = new TimeTask();
            t.setCurr(text);
            System.out.println(text);
            new Thread(t,"idleCheckThread").start();
            t.setLast(text);
        }

    }
}

@Data
class TimeTask implements Runnable{
    private static final int LIMIT = 5;
    public volatile String curr = null;
    public volatile String last = null;
    final static Timer timer = new Timer();

    @Override
    public void run() {
        timer.schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                i++;
                boolean con1 = curr==null&& (i >= LIMIT);
                boolean con2 = curr!=null&&curr.equals(last)&&(i >= LIMIT);
                boolean con3 = curr!=last;

                if(con3){
                    timer.cancel();
                }else if (con1||con2) {
                    System.out.println("超时！");
                    timer.cancel();
                } else {
                    System.out.print(i + "\t");
                }
            }
        }, 0, 1000);
    }
}