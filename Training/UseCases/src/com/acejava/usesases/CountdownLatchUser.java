package com.acejava.usesases;

public class CountdownLatchUser {

	public static void main(String[] args) {
		System.out.println("Demo of CountdownLatch");
		CountdownLatchUser countdownlatchuser = new CountdownLatchUser();
		CountdownLatch latch = new CountdownLatch(3);
		Thread worker = new Thread(countdownlatchuser.new worker(latch,0));
		Thread worker1 = new Thread(countdownlatchuser.new worker(latch,1));
		Thread worker2 = new Thread(countdownlatchuser.new worker(latch,2));
		Thread supervisor = new Thread(countdownlatchuser.new supervisor(latch));
		
		supervisor.start();
		worker.start();
		worker1.start();
		worker2.start();
		
	}

	private class worker implements Runnable{
		CountdownLatch latch;
		int workerIdentifier;
		public worker(CountdownLatch latch, int workerIdentifier){
			this.latch = latch;
			this.workerIdentifier = workerIdentifier;
		}
		
		public void run() {
			System.out.println("In worker: "+workerIdentifier);
			latch.countdown();
		}
		
	}
	
	private class supervisor implements Runnable{
		CountdownLatch latch;
		
		public supervisor(CountdownLatch latch){
			this.latch = latch;
		}
		
		public void run() {
			try {
				System.out.println("waiting for worker task to finish");
				latch.await();
			} catch (InterruptedException e) {
				System.out.println("Error: ");
				e.printStackTrace();
			}
			System.out.println("All worker task completed");			
		}
	}
	
}
