package com.acejava.usesases;

public class RentrantLockExample {

	private Object monitor;
	private Thread current;
	private int count;

	public RentrantLockExample(){
		monitor = new Object();
		count = 0;
		current = null;
	}
	
	public void  lock() throws InterruptedException{
		synchronized(monitor){
			
			while(null != current && current != Thread.currentThread()){
				monitor.wait();
			}
			System.out.println("got the lock");
			count++;
			current = Thread.currentThread();
			/*if(null == current || current == Thread.currentThread()){
				System.out.println("got the lock");
				count++;
				current = Thread.currentThread();
			}

			else{
				monitor.wait();
			}*/
		}
	}

	public void unlock(){
		synchronized(monitor){
			if(current == Thread.currentThread()){
				System.out.println("released the lock");
				count--;
			}
			
			if(count == 0){
				current = null;
				monitor.notifyAll();
			}
		}
	}
}
