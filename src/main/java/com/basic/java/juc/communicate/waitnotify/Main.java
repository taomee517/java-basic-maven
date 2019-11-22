package com.basic.java.juc.communicate.waitnotify;

public class Main {
	public static void main(String[] args) {
		Factory fa=new Factory();
		Shop shop=new Shop();
		Store house=new Store();
		fa.setHouse(house);
		shop.setHouse(house);
		fa.start();
		shop.start();
	}
}
