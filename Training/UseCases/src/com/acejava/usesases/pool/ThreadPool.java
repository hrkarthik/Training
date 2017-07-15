package com.acejava.usesases.pool;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {

	private final int size;
	private volatile boolean stop = false;
	private final ArrayList<Thread> threadList = new ArrayList<Thread>();
	private final BlockingQueue<Runnable> workQueue;
	private final ReentrantLock mainLock = new ReentrantLock();

	public ThreadPool(int size){
		this.size = size;
		workQueue = new LinkedBlockingQueue<Runnable>();
	}

	public void initialize(){
		for(int i =0; i<size; i++){
			Worker workerThread = this.new Worker();
			workerThread.setName(Integer.toString(i));
			workerThread.start();
			threadList.add(workerThread);
		}

	}

	public void submit(Runnable task) throws InterruptedException{		
		workQueue.put(task);
	}

	public void shutdown(){
		mainLock.lock();
		try{
			if(true != stop){
				stop = true;
			}
			else
				return;
			System.out.println("in shutown");
			
			for(Thread thread: threadList){
				try{
					thread.interrupt();
				}
				catch(SecurityException e){
					System.out.println("Error: "+"got security exception");
				}			
			}
		}
		finally{
			mainLock.unlock();
		}
	}

	private class Worker extends Thread{

		@Override
		public void run(){
			while(true != stop){
				try {
					Runnable task = workQueue.take();				
					task.run();
				} catch (Exception e) {
					//log it
				}
			}
		}
	}
}
