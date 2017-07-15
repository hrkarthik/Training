package com.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamWithObjects {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();

		emp.add(new Employee(0, 10, "a"));
		emp.add(new Employee(1, 11, "b"));
		emp.add(new Employee(2, 12, "c"));
		emp.add(new Employee(3, 13, "d"));
		emp.add(new Employee(4, 14, "e"));
		emp.add(new Employee(5, 15, "f"));
		
		emp.forEach(System.out::println);
		
		emp.stream().filter(obj -> obj.id>3)
		.mapToInt(obj -> obj.id)
		.forEach(System.out::println);
	}

	public static class Employee{
		
		int id;
		int salary;
		String name;
		
		public Employee(int id, int salary, String name) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}
	}
}
