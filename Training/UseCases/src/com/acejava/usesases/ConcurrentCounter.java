package com.acejava.usesases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentCounter {

	AtomicInteger counter = new AtomicInteger();
	//public static volatile double count = 0;
	public static int count = 0;
	
	public static void main(String[] args) {
		System.out.println("Demo of ConcurrentCounter");
		ConcurrentCounter conCounter = new ConcurrentCounter();
		ExecutorService executor = Executors.newScheduledThreadPool(corePoolSize).newFixedThreadPool(10);
		for(int i=0; i<10; i++){
			executor.submit(conCounter.new Worker());
		}
		executor.shutdown();
	}

private class Worker implements Runnable{	

	public void run() {
		System.out.println(Thread.currentThread().getName()+": Count value: "+counter.incrementAndGet());		
		count++;
		System.out.println(Thread.currentThread().getName()+": Count value: "+count);
	}
}
}
