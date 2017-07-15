package com.java.acejava.sync;

public class SingletonMain {


	public static void main(String[] args) {
		System.out.println("in main");
		SingletonMain obj = new SingletonMain();
		Runnable task = obj.new worker();
		
		Thread t1 = new Thread(task,"Thread1");
		Thread t2 = new Thread(task,"Thread2");
		t1.start();
		t2.start();
	}

	private class worker implements Runnable{

		@Override
		public void run() {
			System.out.println("in run");
			Singleton obj;
			try {
				obj = Singleton.getInstance();
				System.out.println(obj.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
