package com.basic.java.juc.communicate.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
	public static void main(String[] args) {

		try (PipedInputStream in=new PipedInputStream();
			 PipedOutputStream out=new PipedOutputStream();){

			in.connect(out);

			Factory fa=new Factory();
			Shop shop=new Shop();

			fa.setOut(out);
			shop.setIn(in);

			fa.start();
			shop.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
