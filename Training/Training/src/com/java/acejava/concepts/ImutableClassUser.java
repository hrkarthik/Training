package com.java.acejava.concepts;

import java.util.ArrayList;

public class ImutableClassUser {

	public static void main(String[] args) {
		ImutableClass obj = new ImutableClass(10, "Java",new ArrayList<Integer>(),new Object());
		System.out.println(obj.getId());
	}

}
