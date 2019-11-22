package com.basic.java.juc.communicate.waitnotify;

public class Factory extends Thread{
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
				System.out.println("工厂正在准备生产第"+i+"件商品");
				
				try {
					if(house.getIndex()<1) {				
						sleep(2000);
						System.out.println("第"+i+"件商品生产完成！");
						house.putin();				
					}else {
						house.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}					
		}
	}
}
