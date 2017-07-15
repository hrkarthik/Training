package com.java.basic;

public class OverloadingError {

	public static void main(String[] args) {
		OverloadingError obj = new OverloadingError();
		//obj.print(1,1);

	}

	public void print(int i, long j){
		System.out.println("in integer");
	}
	
	public void print(long i, int j){
		System.out.println("in int");
	}
	
	
}
