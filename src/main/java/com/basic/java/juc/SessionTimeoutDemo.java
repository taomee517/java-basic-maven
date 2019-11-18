////package com.basic.java.juc;
////
////import java.util.Scanner;
////import java.util.Timer;
////import java.util.TimerTask;
////
/////**
//// * @author LuoTao
//// * @email taomee517@qq.com
//// * @date 2019/2/15
//// * @time 10:07
//// */
////public class SessionTimeoutDemo {
////    public static void main(String[] args) {
////        ThreadLocal<String> last = new ThreadLocal<>();
////        ThreadLocal<String> curr = new ThreadLocal<>();
////        String text = null;
////        while (true) {
////            Scanner input = new Scanner(System.in);
////            text = input.nextLine();
////            System.out.println(text);
////            curr.set(text);
////            new Thread(new Runnable(){
////                @Override
////                public void run() {
////                    Timer timer = new Timer();
////                    timer.schedule(new TimerTask() {
////                        int i = 0;
////                        @Override
////                        public void run() {
////                            if (curr.get().equals(last.get())&&i >= 3) {
////                                System.out.println("超时！");
////                                timer.cancel();
////                            } else {
////                                System.out.println(i++);
////                            }
////                        }
////                    }, 0, 1000);
////                }
////            }).start();
////            last.set(text);
////        }
////
////    }
////}


package com.basic.java.juc;

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

class TimeTask implements Runnable{
    public volatile String curr = null;
    public volatile String last = null;
    final static Timer timer = new Timer();

    @Override
    public void run() {
        timer.schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                boolean con1 = curr==null&& (i >= 3);
                boolean con2 = curr!=null&&curr.equals(last)&&(i >= 3);
                boolean con3 = curr!=last;

                if(con3){
                    timer.cancel();
                }else if (con1||con2) {
                    System.out.println("超时！");
                    timer.cancel();
//                    ThreadGroup group = Thread.currentThread().getThreadGroup();
//                    int threadSize = group.activeCount();
//                    Thread[] threads = new Thread[threadSize];
//                    group.enumerate(threads);
//                    for (int i = 0; i < threadSize; i++){
//                        String name = threads[i].getName();
//                        System.out.println(name);
//                        if("idleCheckThread".equals(name)){
//                            threads[i].interrupt();
//                        }
//                    }
                } else {
                    System.out.println(i++);
                }
            }
        }, 0, 1000);
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}

