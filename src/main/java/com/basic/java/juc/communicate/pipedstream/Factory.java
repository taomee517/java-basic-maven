package com.basic.java.juc.communicate.pipedstream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Factory extends Thread{
	private PipedOutputStream out;

	public PipedOutputStream getOut() {
		return out;
	}

	public void setOut(PipedOutputStream out) {
		this.out = out;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("工厂正在准备生产第"+i+"件商品");
			try {
				sleep(2000);
				System.out.println("第"+i+"件商品生产完毕");
				out.write(i);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
