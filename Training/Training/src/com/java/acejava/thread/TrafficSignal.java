package com.java.acejava.thread;


public class TrafficSignal {

	public static volatile boolean stop;
	public static int myValue = 0;
	public static TrafficSignal obj;
	public static Object lock;

	public static void main(String[] args) {
		obj = new TrafficSignal();
		lock = new Object();

		Thread t1 = new Thread(obj.new Worker1(),"Worker1");
		Thread t2 = new Thread(obj.new Worker2(),"Worker2");
		Thread t3 = new Thread(obj.new Worker3(),"Worker3");
		Thread t4 = new Thread(obj.new Worker4(),"Worker4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void sleep(long value){
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	private class Worker1 implements Runnable{

		@Override
		public void run() {
			while(!stop){
				//System.out.println(Thread.currentThread().getName()+" In while" );
				if(myValue != 0)
					System.out.println(Thread.currentThread().getName()+" : READ");
				synchronized(lock){


					while(myValue != 0){
						try {							
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}					
					System.out.println(Thread.currentThread().getName()+" : GREEN");
					sleep(5000);
					myValue++;							
					lock.notifyAll();
				}
			}

		}

	}

	private class Worker2 implements Runnable{

		@Override
		public void run() {
			while(!stop){
				//System.out.println(Thread.currentThread().getName()+" In while" );
				if(myValue != 1)
					System.out.println(Thread.currentThread().getName()+" : READ");				
				synchronized(lock){

					while(myValue != 1){
						try {							
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}					
					System.out.println(Thread.currentThread().getName()+" : GREEN");
					sleep(5000);
					myValue++;						
					lock.notifyAll();
				}
			}

		}

	}

	private class Worker3 implements Runnable{

		@Override
		public void run() {
			while(!stop){
				//System.out.println(Thread.currentThread().getName()+" In while" );
				if(myValue != 2)
					System.out.println(Thread.currentThread().getName()+" : READ");
				synchronized(lock){

					while(myValue != 2){
						try {							
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}

					System.out.println(Thread.currentThread().getName()+" : GREEN");
					sleep(5000);
					myValue++;						
					lock.notifyAll();
				}
			}

		}

	}

	private class Worker4 implements Runnable{

		@Override
		public void run() {
			while(!stop){
				//System.out.println(Thread.currentThread().getName()+" In while" );
				if(myValue != 3)
					System.out.println(Thread.currentThread().getName()+" : READ");
				synchronized(lock){			

					while(myValue != 3){
						try {							
							lock.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}

					System.out.println(Thread.currentThread().getName()+" : GREEN");
					sleep(5000);
					myValue = 0;					
					lock.notifyAll();
				}
			}

		}

	}

}
