package com.acejava.usesases.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ObjectPoolExample <T>{
	
	private int poolSize;
	private Factory<T> objectFactory;
	
	private BlockingQueue<T> queue;
	
	public ObjectPoolExample(int poolSize, Factory<T> objectFactory){
		if(poolSize<=0 || poolSize>16){
			poolSize = 16;
		}
		else{
			this.poolSize = poolSize;
		}
		queue = new LinkedBlockingDeque<>(poolSize);
		this.objectFactory = objectFactory;
	}
	
	public T takeObject() throws InterruptedException{		
		return queue.take();		
	}
	
	public void giveObject(T resource) throws InterruptedException{
		//validate();
		//Implement the validate interface to validate the given object is valid and 
		//then insert it into the queue
		queue.put(resource);
	}	
	
	public void initialise(){
		for(int i=0; i<poolSize; i++){
			queue.add(objectFactory.createObject());
		}
	}
}
