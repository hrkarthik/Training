package com.java.acejava.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Callable;

public class ThreadBasic {

	public static void main(String[] args) {
		ThreadBasic obj = new ThreadBasic();
		System.out.println("in main");
		Thread t1 = new Thread(obj.new Worker(),"MyThread");
		t1.setDaemon(true);
		//t1.start();
		
		/*ExpWOrker cWorker = obj.new ExpWOrker();
		try {
			cWorker.call();
		} catch (Exception e1) {
			System.out.println("In Exception");
			e1.printStackTrace();
		}*/
		
		t1.setUncaughtExceptionHandler(obj.new Exceptions());
		
		t1.start();
		/*try {
			t1.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}*/
		
		System.out.println("main ended");

	}

	private class Worker implements Runnable{

		long startTime = System.currentTimeMillis();
		int no = 0;		
		@Override
		public void run() {
			while(System.currentTimeMillis()-startTime < 100){
				System.out.println("Printing no: "+no);
				no++;
			}
			throw new NullPointerException("I am out");
		}
		
	}
	
	private class Exceptions implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(t.getName()+e.getMessage());			
		}	
	}
	
	/*private class ExpWOrker implements Callable<Object>{

		long startTime = System.currentTimeMillis();
		int no = 0;
		@Override
		public Object call() throws Exception {
			while(System.currentTimeMillis()-startTime < 10){
				System.out.println("Printing no: "+no);
				no++;
			}			
			throw new NullPointerException("I am out");			
		}		
	}*/
}
