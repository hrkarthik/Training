package com.acejava.usesases;

public class CyclicBarrierUser {	
	static CyclicBarrierExample cyclicBarrier;

	public static void main(String[] args) {
		System.out.println("Cyclic Barrier demo");
		CyclicBarrierUser cyclicBarrierUser = new CyclicBarrierUser();
		Runnable finalTask = new Runnable() {

			public void run() {
				System.out.println("All task completed performing cleanup task");

			}
		};

		cyclicBarrier = new CyclicBarrierExample(3, finalTask);
		Thread worker1 = new Thread(cyclicBarrierUser.new worker(1));
		Thread worker2 = new Thread(cyclicBarrierUser.new worker(2));
		Thread worker3 = new Thread(cyclicBarrierUser.new worker(3));

		worker1.start();
		worker2.start();
		worker3.start();

	}

	private class worker implements Runnable{

		private int id;
		private Long time = System.currentTimeMillis();

		public worker(int id) {
			this.id = id;
		}
		public void run() {
			while(1000>System.currentTimeMillis()-time){
				System.out.println("in task "+id);
				try {
					cyclicBarrier.await();
					System.out.println("last has arrived");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
