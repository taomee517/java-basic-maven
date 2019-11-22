package com.basic.java.juc.communicate.waitnotify;

public class Shop extends Thread {
	private Store house;

	public Store getHouse() {
		return house;
	}

	public void setHouse(Store house) {
		this.house = house;
	}

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			synchronized (house) {
				try {
					System.out.println("客户准备买第"+i+"件商品");
					if(house.getIndex()>0) {
						sleep(2000);
						System.out.println("购买第"+i+"件商品完成！");
						house.putout();
						house.notify();
					}else {
						house.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
