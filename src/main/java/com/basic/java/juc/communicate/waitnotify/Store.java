package com.basic.java.juc.communicate.waitnotify;

public class Store {
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public void putin() {
		index++;
	}
	public void putout() {
		index--;
	}
}
