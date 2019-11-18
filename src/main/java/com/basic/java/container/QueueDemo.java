package com.basic.java.container;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/2/14
 * @time 13:26
 * @Desc 将队列中的偶数排在最后，将奇数打印出来，并poll出队列
 */
public class QueueDemo {
    public static void main(String[] args) throws Exception {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        for(int i=0;i<10;i++){
            int x = new Random().nextInt(10);
           queue.add(x);
        }
        int size = queue.size();
        for(int i=0;i<size;i++){
            int value = queue.element();
            if(value%2==0){
                queue.poll();
                queue.put(value);
            }else{
                System.out.println("奇数值：" + value);
                queue.poll();
            }
        }
        System.out.println("偶数值个数：" + queue.size());
        queue.stream().forEach(p-> System.out.print(p + "\t"));
    }
}
