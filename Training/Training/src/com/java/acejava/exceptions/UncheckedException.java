package com.java.acejava.exceptions;

public class UncheckedException {

	public static void main(String[] args) {
		uncheckException();
		System.out.println("After exception");

	}

	public static void uncheckException(){
		throw new RuntimeException("i am out");
	}
}
