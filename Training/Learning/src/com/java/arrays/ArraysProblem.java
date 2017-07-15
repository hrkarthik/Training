package com.java.arrays;

import java.util.Arrays;

public class ArraysProblem {

	public static void main(String[] args) {
		ArraysProblem obj = new ArraysProblem();
		int a[] = {1,3,4,8,9,11,13};
		int b[] = {2,5,6,7,10,12};

		int c[] = {2,8,3,5,9};
		int d[] = {10,1,6,4,7};

		//obj.mergeTwoSortedArrays(a, b);
		//System.out.println(obj.findElementInMergedArray(c, d, 5));
		System.out.println(obj.findLeastInRotatedSortedArray(new int[]{11,12,3,4,5,6,7,8,9,10},0,9));
		//System.arraycopy(a, 0, b, b.length, a.length);
	}

	public void mergeTwoSortedArrays(int a[], int b[]){
		int i = 0, j = 0, k = 0;

		int c[] = new int[a.length+b.length];
		while(i<a.length && j<b.length){
			if(a[i]<b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while(i<a.length)
			c[k++] = a[i++];

		while(j<b.length)
			c[k++] = b[j++];


		System.out.println(Arrays.toString(c));
	}

	//Given two unsorted int arrays, find the kth element in the merged, sorted array. 

	public int findElementInMergedArray(int a[], int b[], int position){
		int c[] = new int[a.length+b.length];
		int i = 0, j = 0, k = 0;

		while(i<a.length)
			c[k++] = a[i++];

		while(j<b.length)
			c[k++] = b[j++];

		System.out.println(Arrays.toString(c));
		System.out.println("merged two arrays");

		//do bubble sort now
		int temp = 0;
		i = 0;
		while(i<c.length){
			j = 1;
			while(j<c.length-i){
				if(c[j-1] > c[j]){
					temp = c[j-1];
					c[j-1] = c[j];
					c[j] = temp;
				}						
				j++;
			}
			if(i == position-1)
				break;
			System.out.println("i: "+i);
			i++;
		}
		System.out.println(Arrays.toString(c));
		System.out.println("i: "+i);
		return c[c.length-i-1];
	}
	
	//There is a sorted array which is rotated so you need to find the smallest element in the O(log n) time.
	
	public int findLeastInRotatedSortedArray(int a[], int start, int end){
		//base condition
		if(null == a)
			return -1;
		
		if(1 == a.length)
			return a[0];
		
		//exit condition
		
		if(start == end)
			return a[start];
		
		int mid = (start+end)/2;
		
		
		if(a[end] < a[mid]){
			return findLeastInRotatedSortedArray(a, mid+1, end);
		}		
		else{
			return findLeastInRotatedSortedArray(a, start, mid);
		}
	}
}
