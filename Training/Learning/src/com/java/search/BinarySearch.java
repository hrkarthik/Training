package com.java.search;

public class BinarySearch {
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int a[] = new int[]{1,2,6,10,22,45,67};
		System.out.println(obj.binarySearch(a, 45));
		System.out.println(obj.binarySearch(a, 0, a.length,90));
	}

	public int binarySearch(int a[], int element){
		int start = 0, end = 0, mid = 0 ;

		start = 0;
		end = a.length;
		
		while(start != end){
			mid = (end+start)/2;
			if(element == a[mid])
				return mid;
			else if(element > a[mid])
				start = mid+1;
			else
				end = mid;
		}
		return -1;
	}
	
	public int binarySearch(int a[], int start, int end, int element){
		//exit condition
		if(start == end){
			return -1;
		}
		
		int mid = (start+end)/2;
		
		if(element == a[mid])
			return mid;			
		else if(element>a[mid])
			return binarySearch(a, mid+1, a.length,element);
		else
			return binarySearch(a, 0, mid,element);
	}
}
