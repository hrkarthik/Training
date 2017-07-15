package com.java.acejava.thread;

import java.lang.Thread.State;

public class TestThreadState {

	static Thread t;
	public static void main(String[] args) {
		System.out.println("in main");
		TestThreadState obj = new TestThreadState();
		t = new Thread(obj.new Worker(),"MyThread");
		
		t.start();
		/*printState();
		
		printState();
		
		sleep(500);
		
		printState();
		t.interrupt();
		sleep(500);
		
		printState();
		printState();
		printState();
		sleep(200);
		
		printState();
		
		printState();
		printState();*/
		
		/*while(!t.getState().equals(State.TERMINATED)){
			sleep(100);
			printState();
			//t.interrupt();			
		}*/
		
		sleep(1000);
		t.interrupt();
		/*synchronized (TestThreadState.class) {
			TestThreadState.class.notify();
		}*/
	}

	public static void printState(){
		/*System.out.println("Thread Name: "+Thread.currentThread().getName()+" --- State: "+
				Thread.currentThread().getState());*/
		System.out.println("Thread Name: "+t.getName()+" --- State: "+t.getState());
	}
	
	public static void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class Worker implements Runnable{
		//Object obj = new Object();
		@Override
		public void run() {
			try {
				/*synchronized(TestThreadState.class){
					TestThreadState.class.wait(50000);					
				}*/
				Thread.sleep(10000);
				System.out.println("after wait and sleep");				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("i am in run");
			
		}
		
	}
}
