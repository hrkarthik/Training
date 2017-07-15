package com.java.acejava.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegers {

	static AtomicInteger atomic; 
	public static void main(String[] args) {
		atomic = new AtomicInteger();
		System.out.println(atomic.get());
		System.out.println(atomic.compareAndSet(0, 2));
		System.out.println(atomic.get());
	}

}
   