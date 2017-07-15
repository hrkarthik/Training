package com.acejava.usesases;

public class CustomBlockingQueueUser {

	static CustomBlockingQueue<Integer> blockingQueue;
	static int size = 5;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("In Blocking queue demo");
		
		CustomBlockingQueueUser queueUser = new CustomBlockingQueueUser();
		blockingQueue = new CustomBlockingQueue<Integer>(size);
		
		AddWorker addWorker = queueUser.new AddWorker();
		addWorker.setNo(30);
		GetWorker getWorker = queueUser.new GetWorker();
		
		for(int i =2; i<size; i++){
			blockingQueue.put(i);
		}
		Thread t1 = new Thread(addWorker);
		Thread t2 = new Thread(getWorker);
		
		t1.start();
		t2.start();
	}

	private class AddWorker implements Runnable{
		private int no;				
		@Override
		public void run() {
			try {
				System.out.println("IN AddWorker");
				blockingQueue.put(no);
				for(int i =0; i<size; i++){
					blockingQueue.put(i);
					System.out.println("In addworker added a member: "+i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void setNo(int no) {
			this.no = no;
		}		
	}
	
	private class GetWorker implements Runnable{

		@Override
		public void run() {
			try {
				int no = blockingQueue.get();
				System.out.println("IN GetWorker: "+no);
				for(int i=3; i<size; i++){
					no = blockingQueue.get();
					System.out.println("IN GetWorker got a menber: "+no);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
