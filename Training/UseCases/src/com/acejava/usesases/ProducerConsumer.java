package com.acejava.usesases;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	Queue<Integer> holder = new LinkedList<Integer>();
	final int maxSize = 10;

	public static void main(String[] args) {
		System.out.println("Demo of producer consumer");
		ProducerConsumer producerconsumer = new ProducerConsumer();
		Thread producer = new Thread(producerconsumer.new Producer(0));
		Thread producer1 = new Thread(producerconsumer.new Producer(1));
		Thread producer2 = new Thread(producerconsumer.new Producer(2));
		Thread consumer = new Thread(producerconsumer.new Consumer(0));
		Thread consumer1 = new Thread(producerconsumer.new Consumer(1));
	
		consumer.start();
		consumer1.start();
		producer.start();
		producer1.start();
		producer2.start();
	}

	private class Producer implements Runnable{
		int order;
		
		public Producer(int order){
			this.order = order;
		}

		public void run() {
			for(int i=0; i<20; i++){
				synchronized (holder) {

					while (holder.size() == maxSize){
						System.out.println("Producer "+order +" : queue is full so waiting");
						try{							
							holder.wait();
						}
						catch(InterruptedException ex){
							System.out.println("Producer "+order +" : Error: ");
							ex.printStackTrace();
						}
					}

					holder.add(i);
					System.out.println("Producer "+order +" : adding element : "+i+" to queue");
					holder.notifyAll();
				}
			}
		}

	}

	private class Consumer implements Runnable{
		int order;
		
		public Consumer(int order) {
			this.order = order;
		}
		
		public void run() {
			while(true){
				synchronized (holder) {
					while(holder.isEmpty()){
						System.out.println("Consumer "+order +" : queue is empty so waiting");
						try {						
							holder.wait();
						} catch (InterruptedException e) {
							System.out.println("Consumer "+order +" : Error: ");
							e.printStackTrace();
						}
					}
					System.out.println("Consumer "+order +" : Got the value: "+holder.remove());
					holder.notifyAll();
				}
			}
		}
	}
}
