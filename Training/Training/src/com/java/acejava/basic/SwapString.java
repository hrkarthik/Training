package com.java.acejava.basic;

public class SwapString {

	public static void main(String[] args) {
		String s1 = "hi";
		String s2 = "hello";
		System.out.println(s1+s2);
		swap(s1,s2);
		System.out.println(s1+s2);
	}

	public static void swap(String s1, String s2){
		//System.out.println(s1+s2);
		String temp = s1;
		s1 = s2;
		s2 = temp;
		//System.out.println(s1+s2);
	}
	
	
}
