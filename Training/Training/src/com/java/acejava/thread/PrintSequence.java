package com.java.acejava.thread;

public class PrintSequence {

	public static volatile boolean stop;
	public static int myValue = 0;
	public static PrintSequence obj;
	public static Object lock;
	public static volatile int count = 0; 
	
	public static void main(String[] args) {
		obj = new PrintSequence();
		lock = new Object();
		
		Thread t1 = new Thread(obj.new Worker1(),"Worker1");
		Thread t2 = new Thread(obj.new Worker2(),"Worker2");
		Thread t3 = new Thread(obj.new Worker3(),"Worker3");
		
		t1.start();
		t2.start();
		t3.start();
	}

	private class Worker1 implements Runnable{

		@Override
		public void run() {
			while(count<15){
				synchronized(lock){
					while(myValue != 0){
						try {
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" : "+count);
					myValue++;
					count++;
					lock.notifyAll();
				}
			}

		}

	}
	
	private class Worker2 implements Runnable{

		@Override
		public void run() {
			while(count<15){
				synchronized(lock){
					while(myValue != 1){
						try {
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" : "+count);
					myValue++;
					count++;
					lock.notifyAll();
				}
			}

		}

	}
	
	private class Worker3 implements Runnable{

		@Override
		public void run() {
			while(count<15){
				synchronized(lock){
					while(myValue != 2){
						try {
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+" : "+count);
					myValue = 0;
					count++;
					lock.notifyAll();
				}
			}

		}

	}
}
