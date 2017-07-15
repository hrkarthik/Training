package com.java.acejava.polymorphism;

public class FinalMethodOverloading {

	public final void print(int i){
		System.out.println(i);
	}
	
	public final void print(int i, int j){
		System.out.println(i+" "+j);
	}
}
