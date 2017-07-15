package com.java.acejava.polymorphism;

public class GenericsOveriding {

	public static void main(String[] args) {
		
		ClassA objectA = new ClassB();
		objectA.disp(new int[]{1,2,3});              
	}		
}
