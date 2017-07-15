package com.java.acejava.thread;

public class OutOfMemoryError {

	static int [] array;
	static int size;
	public static void main(String[] args) throws InterruptedException {
		System.out.println("in main");
				
		try{
		    long maxMemory = Runtime.getRuntime().maxMemory();
			System.out.println(maxMemory);

			Thread.sleep(10000);
			size = (int) (maxMemory>>4);
			System.out.println(size);

			call();
			 		
		}
		catch(Throwable e){
			//e.getMessage();
			e.printStackTrace();	
			Thread.sleep(10000);
			//call();
		}
		System.out.println("after main");
	}
	
	public static void call() throws InterruptedException{
		for(int i=0; i<4; i++){				
			array = new int[size];
			Thread.sleep(10000);
			size = size<<1;			
		}	
	}
}

