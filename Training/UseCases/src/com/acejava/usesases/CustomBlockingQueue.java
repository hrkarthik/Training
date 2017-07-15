package com.acejava.usesases;

import java.util.LinkedList;

public class CustomBlockingQueue<T> {

	private int size;
	private int count;
	private LinkedList<T> queue;
	private Object monitor = new Object();

	public CustomBlockingQueue(int size){
		this.size = size;
		queue = new LinkedList<T>();
	}

	public T get() throws InterruptedException{
		T t;
		synchronized(monitor){
			if(count == 0){
				monitor.wait();
			}
			t = queue.remove();
			count--;
			monitor.notifyAll();
		}
		return t;
	}

	public void put(T t) throws InterruptedException{
		synchronized(monitor){
			if(count == size){
				monitor.wait();
			}
			queue.add(t);
			count++;
			monitor.notifyAll();
		}
	}
}
