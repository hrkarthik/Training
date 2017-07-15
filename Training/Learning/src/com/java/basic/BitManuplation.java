package com.java.basic;

public class BitManuplation {

	public static void main(String[] args) {
		int x = 0x00000002;				
		int y = 4;
		int c = 1;
		int a = 5;
		
		int z = x|y|c|a;
		
		System.out.println(z);

		int arr[] = new int[] {1,2};
		
		System.out.println(arr['a']);
	}

}
