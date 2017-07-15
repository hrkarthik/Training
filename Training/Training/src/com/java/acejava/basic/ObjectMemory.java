package com.java.acejava.basic;

public class ObjectMemory {

	public static void main(String[] args) {
		/*System.gc();
		System.gc();
		System.gc();
		System.gc();*/
		
		long before = Runtime.getRuntime().freeMemory();
		System.out.println(before);
		//System.gc();
		Object obj = new Object();
		//A objA = new A();
/*		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Object obj4 = new Object();*/
		
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		
		long after = Runtime.getRuntime().freeMemory();
		System.out.println(after);
		
		long result = before-after;
		byte d = (byte)result;
		System.out.println(d);

	}

	private static class A{
		
	}
}
