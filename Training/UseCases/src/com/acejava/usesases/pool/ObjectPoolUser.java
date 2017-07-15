package com.acejava.usesases.pool;

import java.util.ArrayList;

public class ObjectPoolUser {

	static ObjectPoolExample<Object> objectPool;
	static int size = 16;
	static ArrayList<Object> list = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		ObjectPoolUser poolUser = new ObjectPoolUser();		
		objectPool = new ObjectPoolExample<Object>(size, poolUser.new ObjectFactory());
		objectPool.initialise();
		poolUser.testGetAllObject();
		//poolUser.testGetObject();
		poolUser.testPutAllObject();
		poolUser.testPutObject();
	}

	public void testGetAllObject() throws InterruptedException{
		for(int i=0; i<size; i++){
			Object obj = objectPool.takeObject();
			list.add(obj);
			System.out.println("Got object: "+i+" : "+obj);
		}
	}
	
	public Object testGetObject() throws InterruptedException{
		Object obj = objectPool.takeObject();
		System.out.println("In get object from pool");
		return obj;
	}
	
	public void testPutObject() throws InterruptedException{		
		objectPool.giveObject(list.get(0));
		System.out.println("Gave object to pool");
	}
	
	public void testPutAllObject() throws InterruptedException{
		for(Object obj: list){
			objectPool.giveObject(obj);
			System.out.println("Gave object");
		}
	}
	
	private class ObjectFactory implements Factory<Object>{

		@Override
		public Object createObject() {			
			return new Object();
		}		
	}
}
