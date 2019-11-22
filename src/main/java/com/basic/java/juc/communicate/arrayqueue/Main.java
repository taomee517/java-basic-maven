package com.basic.java.juc.communicate.arrayqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	public static void main(String[] args) {
		Factory fa=new Factory();
		Shop shop=new Shop();
		ArrayBlockingQueue<Integer> abq=new ArrayBlockingQueue<>(4);
		fa.setAbq(abq);
		shop.setAbq(abq);
		fa.start();
		shop.start();
	}
}
