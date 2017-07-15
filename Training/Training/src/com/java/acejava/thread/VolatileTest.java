package com.java.acejava.thread;

public class VolatileTest {

	boolean stop = false;
	//static VolatileTest obj;
	
	public static void main(String[] args) {
		System.out.println("in main");
		VolatileTest obj = new VolatileTest();

		Thread start = new Thread(obj.new StartWorker(obj));
		Thread stop = new Thread(obj.new StopWorker(obj));
		
		start.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//stop.start();
	}

	
	public void start(){
		System.out.println("in started");
		while(!stop){
			
		}		
		System.out.println("ended");
	}
	
	public void stop(){
		System.out.println("in stop");
		stop = true;
	}
	
	private class StartWorker implements Runnable{

		VolatileTest obj;
		
		public StartWorker(VolatileTest obj) {
			this.obj = obj;
		}
		
		@Override
		public void run() {
			obj.start();			
		}		
	}
	
	private class StopWorker implements Runnable{
		VolatileTest obj;
		
		public StopWorker(VolatileTest obj) {
			this.obj = obj;
		}
		
		@Override
		public void run() {
			obj.stop();			
		}		
	}
}
