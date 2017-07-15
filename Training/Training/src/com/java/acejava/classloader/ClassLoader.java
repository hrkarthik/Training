package com.java.acejava.classloader;

public class ClassLoader {

	public static void main(String[] args) {
		MyCustomClassLoader classLoader1 = new MyCustomClassLoader();
		MyCustomClassLoader classLoader2 = new MyCustomClassLoader();
		
		try {
			Class<?> class1 = classLoader1.loadClass("ClassB",true);
			System.out.println(class1.getName());
			System.out.println(class1.getClassLoader());
			
			//class1.getMethod(name, parameterTypes)
			
			Class<?> class2 = classLoader2.loadClass("ClassB",true);
			System.out.println(class2.getName());
			System.out.println(class2.getClassLoader());
			
			if(class1 == class2){
				System.out.println(" not Broken");
			}
			
			//Class1 obj1 = class1.newInstance();
			
			System.out.println(ClassB.class.getClassLoader());			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
