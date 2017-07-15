package com.java.acejava.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindElement {

	public static int size = 1000000;
	public int[] arrays = new int[size];
	public static int perThreadSize;
	public static int find = 23;
	//public List<>
	
	public static void main(String[] args) {
		FindElement obj = new FindElement();
		Future<Boolean> futureTask;
		int start = 0;
		int end = 0;
		perThreadSize = size/5;
		end = perThreadSize-1;

		ExecutorService executor = Executors.newFixedThreadPool(5);

		for(int i=0; i<5; i++){
			futureTask = executor.submit(obj.new Worker(start, end));
			start = end+1;
			end = start+end;
		}				

		//futureTask.
	}

	private class Worker implements Callable<Boolean>{

		int start;
		int end;

		public Worker(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public Boolean call() throws Exception {
			for(int i=start ; i<=end; i++){				
				if(arrays[i] == find){
					return true;
				}				
			}
			return false;
		}		
	}
}
