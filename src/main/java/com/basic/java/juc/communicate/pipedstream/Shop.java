package com.basic.java.juc.communicate.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;

public class Shop extends Thread {
	private PipedInputStream in;

	public PipedInputStream getIn() {
		return in;
	}

	public void setIn(PipedInputStream in) {
		this.in = in;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("客户正准备购买第"+i+"件商品");
			try {
				sleep(2000);
				//read方法是一个阻塞方法
				//当缓存中暂时没有数据时 获取数据的方法处于阻塞状态
				int num=in.read();
				System.out.println("购买第"+num+"件商品完成");
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}			
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
