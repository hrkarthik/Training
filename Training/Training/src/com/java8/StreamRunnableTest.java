package com.java8;

public class StreamRunnableTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("in run");
				
			}
			
		});
		
		Thread t1 = new Thread(() -> System.out.println("in run lambda"));

		t1.start();
	}

}
