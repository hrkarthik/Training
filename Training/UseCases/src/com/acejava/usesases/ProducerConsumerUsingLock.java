package com.acejava.usesases;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLock {

	Queue<Integer> holder = new LinkedList<Integer>();
	final int maxSize = 10;
	boolean stop = true;
	//ReentrantLock lock = new ReentrantLock();

	ReentrantLock producerLock = new ReentrantLock();
	Condition fullCondition = producerLock.newCondition();

	ReentrantLock consumerLock = new ReentrantLock();	
	Condition emptyCondition = consumerLock.newCondition();

	public static void main(String[] args) throws InterruptedException {

		ProducerConsumerUsingLock obj = new ProducerConsumerUsingLock();
		Thread helper = new Thread(obj.new Helper());
		

		Thread producer = new Thread(obj.new producer(0));
		Thread producer1 = new Thread(obj.new producer(1));
		Thread consumer = new Thread(obj.new consumer(0));
		Thread consumer1 = new Thread(obj.new consumer(1));


		consumer.start();
		consumer1.start();
		helper.start();
		Thread.sleep(100);
		producer.start();
		producer1.start();

	}

	private class producer implements Runnable{

		int order;

		public producer(int order){
			this.order = order;
		}

		@Override
		public void run() {			
			for(int i=0; i<20; i++){
				producerLock.lock();
				if(holder.size() == maxSize){
					System.out.println("Aquring producer lock");
					try {
						fullCondition.await();
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					System.out.println("After lock");
				}
				
				holder.add(i);
				System.out.println("Producer : "+order+ " Added item: "+i);
				producerLock.unlock();
				
				consumerLock.lock();
				emptyCondition.signal();
				consumerLock.unlock();

			}
			
		}

	}

	private class consumer implements Runnable{

		int order;

		public consumer(int order){
			this.order = order;
		}

		@Override
		public void run() {			
			for(int i=0; i<20; i++){
				consumerLock.lock();
				if(holder.isEmpty()){
					System.out.println("Aquring consumer lock");
					try {
						emptyCondition.await();
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}

				System.out.println("Consumer : "+order+" Consumed iteam: "+holder.poll());
				consumerLock.unlock();
				
				producerLock.lock();							
				fullCondition.signal();
				producerLock.unlock();

			}
			
		}

	}

	private class Helper implements Runnable{

		@Override
		public void run() {
			while(stop){
				System.out.println("consumerLock HoldCount: "+consumerLock.getHoldCount());
				System.out.println("consumerLock QueueLength: "+consumerLock.getQueueLength());
				System.out.println("producerLock HoldCount: "+producerLock.getHoldCount());
				System.out.println("producerLock QueueLength: "+producerLock.getQueueLength());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
		
	}
}

