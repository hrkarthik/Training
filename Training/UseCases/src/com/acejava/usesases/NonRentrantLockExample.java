package com.acejava.usesases;

public class NonRentrantLockExample {
	private Object monitor;
	private Thread current;

	public NonRentrantLockExample(){
		monitor = new Object();		
		current = null;
	}

	public void  lock() throws InterruptedException{
		synchronized(monitor){
			if(null == current ){
				System.out.println("got the lock");				
				current = Thread.currentThread();
			}

			else{
				monitor.wait();
			}
		}
	}

	public void unlock(){
		synchronized(monitor){
			if(current == Thread.currentThread()){
				System.out.println("released the lock");
				current = null;
				monitor.notifyAll();
			}			
		}
	}
}
