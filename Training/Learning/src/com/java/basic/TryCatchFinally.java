package com.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryCatchFinally {

	public static void main(String[] args) {
		
		Integer a[] = {1,2,3};
		
		TryCatchFinally obj = new TryCatchFinally();
		System.out.println(obj.checkReturn());		

		List<List<Integer>> listoflists = new ArrayList<>();
		listoflists.add(Arrays.asList(a));
		
		String s1 = null;
		
		if(s1.equals(null)){
			System.out.println("in if");
		}
	}

	public String checkReturn(){
		try{
			System.out.println("in try");
			return "try";
		}
		catch (Exception e){
			System.out.println("in catch");
			return "catch";
		}
		finally {
			System.out.println("in finally");
			return "finally";
		}
	}
}
