package com.acejava.usesases.pool;

public class ThreadPoolUser {

	static final ThreadPoolUser threadPoolUser = new ThreadPoolUser();
	static final ThreadPool pool = new ThreadPool(5);
	
	public static void main(String[] args) {
		System.out.println("ThreadPool Demo class");
		
		pool.initialize();
		
		for(int i=0; i<10; i++){			
			Task newTask = threadPoolUser.new Task();
			try {
				pool.submit(newTask);
			} catch (InterruptedException e) {
				System.out.println("Error: while submitting task");
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		pool.shutdown();

		Thread shutdownThread = new Thread(new Runnable() {
			
			public void run() {
				pool.shutdown();				
			}
		});
		
		shutdownThread.start();
	}

	private class Task implements Runnable{
		
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+": hello i am in");
			
		}
		
	}
}
