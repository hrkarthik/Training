package com.java.acejava.collections;

import java.util.Vector;

public class VectorIteratorTest {

	public static void main(String[] args) {
		
		//Thread t1 = new Thread(new )

	}

	private class Worker implements Runnable{
		private Vector<Integer> integerList;
		private boolean write;
		
		public Worker(Vector<Integer> integerList, boolean write) {
			this.integerList = integerList;
			this.write = write;
		}

		@Override
		public void run() {
			if(write){
				integerList.addElement(2);
				System.out.println("in write");
			}
			else{
				integerList.remove(0);
				System.out.println("after remove");
			}
			
		}
		
	}
}
