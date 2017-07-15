package com.java.acejava.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	ReentrantLock lock1 = new ReentrantLock();
	Condition condition1 = lock1.newCondition();
	ReentrantLock lock2 = new ReentrantLock();
	Condition condition2 = lock2.newCondition();
	boolean flag = false;

	public static void main(String[] args) {
		LockTest obj = new LockTest();

		Thread t1 = new Thread(obj.new Worker1());
		Thread t2 = new Thread(obj.new Worker2());

		t2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
	}

	private class Worker1 implements Runnable {

		@Override
		public void run() {
			lock1.lock();
			System.out.println("Took lock in 1: "+lock1.getHoldCount()+" Queue Length : "+lock1.getQueueLength());
			try {
				if(flag){
					System.out.println("taking lock in 1");
					condition1.await();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lock2.lock();
			System.out.println("singalling for 2");
			condition2.signalAll();
			lock2.unlock();
			
			lock1.unlock();
		}

	}

	private class Worker2 implements Runnable {

		@Override
		public void run() {
			lock2.lock();
			System.out.println("Took lock in 2: " + lock1.getHoldCount() + " Queue Length : " + lock1.getQueueLength());
			try {
				if (!flag) {
					System.out.println("taking lock in 2");
					condition2.await();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lock1.lock();
			System.out.println("singalling for 1");
			condition1.signal();
			lock1.unlock();
			
			lock2.unlock();

		}

	}
}
