package com.java.acejava.polymorphism;


public class ClassB extends ClassA{

	public int i = 20;	
	
	/*public void print(){
		this.disp();
	}*/		
	
	public void disp(int...i){
		System.out.println(i);
	}	
}
