package com.java.acejava.basic;

public class ObjectSwap {

	public static void main(String[] args) {
		ObjectSwap obj = new ObjectSwap();
		Employee e1 = obj.new Employee(10,"specimen");
		Employee e2 = obj.new Employee(20,"specimen2");		
		System.out.println(e1.id+"   "+e2.id);
		obj.swap(e1,e2);
		System.out.println(e1.id+"   "+e2.id);
	}

	public void swap(Employee e1, Employee e2){
		Employee temp = e1;
		e1 = e2;
		e2 = temp;
	}
	
	class Employee{
		int id;
		String name;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}	
}
