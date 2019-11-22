package com.basic.java.juc.communicate.arrayqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Factory extends Thread {
	private ArrayBlockingQueue<Integer> abq;

	public ArrayBlockingQueue<Integer> getAbq() {
		return abq;
	}

	public void setAbq(ArrayBlockingQueue<Integer> abq) {
		this.abq = abq;
	}

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("工厂正在准备生产第"+i+"件商品");
			try {
				sleep(2000);
				abq.put(i);
				System.out.println("第"+i+"件商品生产完毕");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
