package com.java.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		
		int a[] = new int[] {5,4,6,1,2,8};
		System.out.println("Before: "+Arrays.toString(a));
		System.out.println("After: "+Arrays.toString(obj.sort(a)));
	}

	public int[] sort(int a[]){
		for(int i = 0; i<a.length; i++){//no of times to repeat the bubble
			for(int j = 1; j<a.length-i; j++){
				if(a[j-1] > a[j]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		return a;
	}
}
