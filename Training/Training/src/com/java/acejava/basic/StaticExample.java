package com.java.acejava.basic;

import java.io.IOException;

public class StaticExample {

	static int i = 10;
	//static int j;
	
	{ i=20;		
		System.out.println("in first");}
	
	
	static{i=30;			
		System.out.println("in second");}
	
	{ i=40;
		System.out.println("in third");}
	
	static{i=50;
		//throw new Exception();
		try{
			throw new IOException();
		}catch(Exception e){
			System.out.println("in exception");
		}
		//System.out.println(i);
		System.out.println("in four");}
	
	//static int i = 10;
	
	
	public static void main(String[] args) {
		System.out.println(new StaticExample().i);
	}
}
