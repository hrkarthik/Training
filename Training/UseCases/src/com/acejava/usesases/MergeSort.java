package com.acejava.usesases;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] numbers = new int[30];

		for(int i=0; i<30; i++){
			long time = System.nanoTime();				
			numbers[i] = (int) ((time >> 1) & 30);				
		}

	}

	public void sort(int[] numbers){
		int n = numbers.length;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for(int i=0; i<mid-1; i++){
			left[i] = numbers[i];
		}
		for(int i=mid,j=0; i<n-1; i++,j++){
			right[j] = numbers[mid];
		}
		
		sort(left);
		sort(right);
		//merge(left,right,)
	}
	
	public void merge(int[] left, int[] right, int[] numbers){
		int l = 0;
		int r = 0;
		int k = 0;
		numbers = new int [left.length+right.length];
		
		while(l<left.length && r<right.length){
			if(left[l] < right[r]){
				numbers[k] = left[l];
				l++;				
			}
			else{
				numbers[k] = right[r];
				r++;
			}
			k++;
		}
		while(l<left.length){
			numbers[k] = left[l];
			k++;
		}
		while(r<right.length){
			numbers[k] = right[r];
			k++;
		}
	}
}
