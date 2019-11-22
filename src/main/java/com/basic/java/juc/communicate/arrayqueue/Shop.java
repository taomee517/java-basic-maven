package com.basic.java.juc.communicate.arrayqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Shop extends Thread {
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
			System.out.println("客户正准备购买第"+i+"件商品");
			try {
				sleep(1000);
				int j=abq.take();
				System.out.println("购买第"+j+"件商品完成");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
