package com.java.acejava.thread;

public class StatckOverflowError {

	public static void main(String[] args) {
		//print();
		for(;;){
			String s =new String("hi");
			if(s == new String("hi")){
				System.out.println(true);
			}
			else{
				System.out.println(false);
			}
			
		}

	}

	public static void print(){
		//String s = new String("hi");
		//String s = new String("hi");
		print();
	}
}
