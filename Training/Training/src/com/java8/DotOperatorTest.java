package com.java8;

public class DotOperatorTest {

	public static void main(String[] args) {
		DotOperatorTest obj = new DotOperatorTest();
		Myclass classObj = obj.new Myclass();

		MyInterface i = () -> System.out.println("in lambda");
		
		MyInterface i1 = () -> classObj.Method1();
		
		MyInterface i2 = classObj::Method1;
		
		//MyInterface i3 = Myclass::new
		
		i.Method1();
		
		i1.Method1();
		
		i2.Method1();
		
	}

	
	private class Myclass implements MyInterface{

		public void Method1(){
			System.out.println("in method1");
		}		
	}
}
