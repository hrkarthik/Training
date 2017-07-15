package com.java.basic;

public class ThreadTest implements Runnable{

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadTest());
		t.run();
		t.run();
		t.start();

	}

	@Override
	public void run() {
		System.out.println("hi");
		
	}

}
