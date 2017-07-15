package com.java.acejava.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadYieldTest {

	public static void main(String[] args) {
		ThreadYieldTest obj = new ThreadYieldTest();
		Thread t1 = new Thread(obj.new worker1());
		Thread t2 = new Thread(obj.new worker2());

		t1.start();
		t2.start();
	}

	private class worker1 implements Runnable{
		long startTime =System.currentTimeMillis();
		int max = 999999;
		int count= 0;
		@Override
		public void run() {
			while(count < max){
				System.out.println("in non yield");	
				count++;
			}			
			long finish = System.currentTimeMillis() - startTime;
			String message = "in non yield: "+ finish;
			writeFile("D:\\java\\kholal\\output\\Noyield.txt",message);
		}
	}

	private class worker2 implements Runnable{
		long startTime =System.currentTimeMillis();
		int max = 999999;
		int count= 0;
		@Override
		public void run() {
			while(count < max){
				System.out.println("in yield");
				if(count>10000 && count%10000 == 0) {					
					Thread.yield();
				}
				count++;
			}
			long finish = System.currentTimeMillis() - startTime;
			String message = "in yield: "+ finish;
			writeFile("D:\\java\\kholal\\output\\yield.txt",message);			
		}
	}
	
	public void writeFile(String name, String message){
		try {
			FileWriter fs = new FileWriter(new File(name),true);
			fs.write(message);
			fs.flush();
			fs.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
