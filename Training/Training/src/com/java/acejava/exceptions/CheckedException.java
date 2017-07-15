package com.java.acejava.exceptions;

public class CheckedException {

	public static void main(String[] args) {

		//checkedExceptions();
		//thowable();
		error();
		System.out.println("after exception");
	}

	public static void checkedExceptions(){
		try {
			throw new Exception("i am out");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void thowable(){
		try {
			throw new Throwable("in throwable");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void error(){
		throw new Error("in error");
	}
}
