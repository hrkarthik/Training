package com.java.acejava.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadLock {
	
	static DeadLock obj;
	public static void main(String[] args) {
		System.out.println("Demo of deadlock");
		obj = new DeadLock();
		Thread t1 = new Thread(obj.new Worker1(),"Worker1");
		Thread t2 = new Thread(obj.new Worker2(),"Worker2");
		
		t1.start();
		t2.start();
		
		System.out.println(t1.getId());
		System.out.println(t2.getId());
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		ThreadMXBean threadMXBean =
	            ManagementFactory.getThreadMXBean();
		long[] deadLockThread = threadMXBean.findDeadlockedThreads();
		
		for(int i=0; i<deadLockThread.length; i++){
			System.out.println(deadLockThread[i]);
		}
		
	}

	private class Worker1 implements Runnable{

		@Override
		public void run() {
			synchronized(obj){
				System.out.println(Thread.currentThread().getName()+" : Got monitor of obj");
				
				synchronized(DeadLock.class){
					System.out.println(Thread.currentThread().getName()+" : Got monitor of class");	
					
				}
			}
			System.out.println(Thread.currentThread().getName()+" : finished run");
		}		
	}
	
	private class Worker2 implements Runnable{

		@Override
		public void run() {
			synchronized(DeadLock.class){
				System.out.println(Thread.currentThread().getName()+" : Got monitor of class");
				
				synchronized(obj){
					System.out.println(Thread.currentThread().getName()+" : Got monitor of obj");	
					
				}
			}
			System.out.println(Thread.currentThread().getName()+" : finished run");
		}
		
	}
}
