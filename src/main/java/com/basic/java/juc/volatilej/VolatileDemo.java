package com.basic.java.juc.volatilej;

/**
 * volatile关键字案例
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\11 0011 13:04
 * @Desc Volatile关键字，当多线程操作共享数据时，可以保证内存数据的可见性，
 *        也可以理解为，volatile关键字修改的数据，是直接在主存中运算的;
 *        相较于Synchronized,它是轻量级的同步策略。
 * 注意：1.volatile不具备互斥性；
 *       2.volatile不能保证数据的原子性；
 *
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Task t = new Task();
        new Thread(t).start();
        while (true){
            if(t.isFlag()){
                System.out.println("修改成功！");
                break;
            }
        }

    }
}

class Task implements Runnable{
    /**如果不加volatile修饰，main方法无法修改成功*/
    private volatile boolean FLAG = false;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FLAG = true;
    }

    public boolean isFlag() {
        return FLAG;
    }

    public void setFlag(boolean flag) {
        this.FLAG = flag;
    }
}
