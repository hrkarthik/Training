package com.java.acejava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HashMapEqualsTest {

	public static void main(String[] args) {
		HashMapEqualsTest obj = new HashMapEqualsTest();
		HashMap<Employee, Integer> map = new HashMap<Employee, Integer>();
		ArrayList<Employee> list = new ArrayList<>();
		
		//Employee[] list = new Employee[4];
		
		Employee ep1 = obj.new Employee(3,"abc");
		Employee ep2 = obj.new Employee(9,"abcd");		
		Employee ep3 = obj.new Employee(1,"abcde");	
		Employee ep4 = obj.new Employee(2,"abcdf");	
		
		
		map.put(ep1, 1);
		map.put(ep2, 2);
		map.put(ep1, 3);
		
		ep1.name = "java";
		
		
		System.out.println(map.size());
		System.out.println(map.get(ep1));
		System.out.println(map.get(ep2));
		
		list.add(ep1);
		list.add(ep2);
		list.add(ep3);
		list.add(ep4);
		
		System.out.println("Before sort");
		for(Employee obj1: list){
			System.out.println(obj1.id);
		}
		
		Collections.sort(list);
		
		System.out.println("After sort");
		for(Employee obj1: list){
			System.out.println(obj1.id);
		}
	}

	private class Employee implements Comparable<Employee>{
		public int id;
		public String name;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			//result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			//System.out.println("RESULT: "+result);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			/*if (!getOuterType().equals(other.getOuterType()))
				return false;*/
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public int compareTo(Employee obj) {			
			if(this.id > obj.id)
				return 1;
			else if(this.id < obj.id)
				return -1;
			else
				return 0;
		}

		/*private HashMapEqualsTest getOuterType() {
			return HashMapEqualsTest.this;
		}*/
	}
}
