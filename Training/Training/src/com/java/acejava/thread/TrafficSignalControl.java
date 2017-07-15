package com.java.acejava.thread;

public class TrafficSignalControl {
	
	public static int myValue = 0;
	static volatile  boolean stop = false;
	
	public static void main(String[] args) {
		
		Object lock = new Object();
		
		Thread t1 = new Thread(new Signal1(lock, myValue, stop), "Thread1");
		Thread t2 = new Thread(new Signal2(lock, myValue, stop), "Thread2");
		Thread t3 = new Thread(new Signal3(lock, myValue, stop), "Thread3");
		Thread t4 = new Thread(new Signal4(lock, myValue, stop), "Thread4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}

class Signal1 implements Runnable {
	Object lock;
	int myValue;
	boolean stop;

	Signal1(Object lock, int myValue, boolean stop) {
		this.lock = lock;
		this.myValue = myValue;
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			if (myValue != 0)
				System.out.println(Thread.currentThread().getName() + " : RED");
			synchronized (lock) {

				while (myValue != 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : GREEN");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				myValue++;
				lock.notifyAll();
			}
		}

	}

}

class Signal2 implements Runnable {

	Object lock;
	int myValue;
	boolean stop;

	Signal2(Object lock, int myValue, boolean stop) {
		this.lock = lock;
		this.myValue = myValue;
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			if (myValue != 1)
				System.out.println(Thread.currentThread().getName() + " : RED");
			synchronized (lock) {

				while (myValue != 1) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : GREEN");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				myValue++;
				lock.notifyAll();
			}
		}

	}

}

class Signal3 implements Runnable {

	Object lock;
	int myValue;
	boolean stop;

	Signal3(Object lock, int myValue, boolean stop) {
		this.lock = lock;
		this.myValue = myValue;
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			if (myValue != 2)
				System.out.println(Thread.currentThread().getName() + " : RED");
			synchronized (lock) {

				while (myValue != 2) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + " : GREEN");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myValue++;
				lock.notifyAll();
			}
		}

	}

}

class Signal4 implements Runnable {

	Object lock;
	int myValue;
	boolean stop;

	Signal4(Object lock, int myValue, boolean stop) {
		this.lock = lock;
		this.myValue = myValue;
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			if (myValue != 3)
				System.out.println(Thread.currentThread().getName() + " : RED");
			synchronized (lock) {

				while (myValue != 3) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + " : GREEN");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myValue = 0;
				lock.notifyAll();
				
			}
		}

	}

}
