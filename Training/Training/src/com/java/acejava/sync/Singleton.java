package com.java.acejava.sync;

public class Singleton {

	private int id;

	private static volatile Singleton Instance = null;

	private Singleton(int id) {
		this.id = id;
	}

	public static Singleton getInstance() throws InterruptedException{	
		System.out.println("in instance");
		
		if(null == Instance){
			System.out.println("in not null");
			
			synchronized(Singleton.class){
				//Singleton.class.wait(100);
				
				if(null == Instance){
					//System.out.println(Thread.currentThread().getName());
					Singleton.class.wait(5000);
					Instance = new Singleton(1);
					System.out.println("Got new instance: "+Thread.currentThread().getName());
				} 
				//Singleton.class.notify();
			}		
		}
		return Instance;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
