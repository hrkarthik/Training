package com.acejava.usesases;

public class CountdownLatch {
	private int count;
	private final Object lock = new Object();
	
	public void await() throws InterruptedException{
		synchronized(lock){
			while(count>0){
				lock.wait();
			}
		}
	}
	
	public void countdown(){
		synchronized (lock) {
			count--;
			if(count == 0){
				lock.notifyAll();
			}
		}
	}
	
	public CountdownLatch(int count){
		this.count = count;
	}
}
