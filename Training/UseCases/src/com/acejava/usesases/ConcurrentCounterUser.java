package com.acejava.usesases;

public class ConcurrentCounterUser {

	public static ConcurrentCounterExample concurrentCounterExample;
	
	public static void main(String[] args) {
		concurrentCounterExample = new ConcurrentCounterExample();
		 
		Thread t1 = new Thread(new Incrementer());
		Thread t2 = new Thread(new Incrementer());
		Thread t3 = new Thread(new Incrementer());

		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();
			
		while(System.currentTimeMillis()-startTime < 3000){
			
		}
		
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
	}

	private static class Incrementer implements Runnable{

		@Override
		public void run() {
			while(!Thread.interrupted()){
				concurrentCounterExample.increment();
				System.out.println("After increment: "+concurrentCounterExample.getCount());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	private static class Decrementer implements Runnable{

		@Override
		public void run() {
			while(!Thread.interrupted()){
				concurrentCounterExample.decrement();
				System.out.println("After decrement: "+concurrentCounterExample.getCount());
				/*try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}*/
			}
			
		}
		
	}
}
