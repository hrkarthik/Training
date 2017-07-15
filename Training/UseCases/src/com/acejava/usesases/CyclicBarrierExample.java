package com.acejava.usesases;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	private int intialCount;	
	private int count;	
	private Object monitor = new Object();	
	private Runnable finalTask;
	private boolean barrierBreak = false;
	
	public CyclicBarrierExample(int count, Runnable finalTask) {
		this.intialCount = count;
		this.count = count;
		this.finalTask = finalTask;
	}
	
	public void await() throws InterruptedException{
		synchronized(monitor){
			count--;
			if(count == 0){
				count = intialCount;
				monitor.notifyAll();
				finalTask.run();		
				return;
			}
			
			else{
				monitor.wait();
			}					
						
		}		
	}
}
