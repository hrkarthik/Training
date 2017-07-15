package com.acejava.usesases;

import java.util.Random;

public class LargestAndSecondLargest {

	static int[] intArray = new int[10];
	static int first = Integer.MAX_VALUE;
	static int second;
	static final int size = 5;
	public static void main(String[] args) {
		System.out.println("Demo for finding LargestAndSecondLargest");
		for(int i=0; i<size; i++){
			Random rand = new Random();
			intArray[i] = rand.nextInt(100);
			System.out.println(intArray[i]);
		}
		findLargestAndSecondLargest();
		System.out.println("First Largest: "+first);
		System.out.println("Second Largest: "+second);
	}

	//These wont work properly if we have duplicates 
	public static void findLargestAndSecondLargest(){
		for(int i=0; i<size; i++){			
			if(intArray[i] < first){
				second = first;
				first = intArray[i];
			}
			else if(intArray[i] < second){
				second = intArray[i];
			}
		}
	}
}
