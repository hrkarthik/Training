package com.acejava.usesases;

import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore {

	private volatile int no;
	private boolean stop = false;
	private static Semaphore consumerlock;
	private static Semaphore producerlock;

	public static void main(String[] args) {
		ProducerConsumerUsingSemaphore obj = new ProducerConsumerUsingSemaphore();
		consumerlock = new Semaphore(0);
		producerlock = new Semaphore(0);
		Thread pr = new Thread(obj.new producer());
		Thread cr1 = new Thread(obj.new consumer());
		Thread cr2 = new Thread(obj.new consumer());
		cr1.start();
		//cr2.start();
		pr.start();
	}

	private class producer implements Runnable{

		@Override
		public void run() {
			while(no<10){

				try {
					System.out.println("in producer: "+no);
					producerlock.release();
					//producerlock.release();
					producerlock.acquire();
					no++;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				consumerlock.release();
			}
		}
	}

	private class consumer implements Runnable{

		
		@Override
		public void run() {
			while(no<10){
				try {
					//System.out.println("in consumer: "+no);
					consumerlock.acquire();
					System.out.println("count: "+no);
					producerlock.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}			
		}		
	}
}
