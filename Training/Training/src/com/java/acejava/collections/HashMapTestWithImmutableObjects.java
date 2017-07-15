package com.java.acejava.collections;

import java.util.HashMap;

public class HashMapTestWithImmutableObjects {

	public static void main(String[] args) {
		HashMapTestWithImmutableObjects obj = new HashMapTestWithImmutableObjects();
		HashMap<Employee,Integer> map = new HashMap<>();
		
		Employee emp1 = obj.new Employee(1, "abc");
		Employee emp2 = obj.new Employee(1, "abc");
		Employee emp3 = obj.new Employee(1, "abc");
		
		Employee emp4 = obj.new Employee(1, "abc");
		map.put(emp1, 1);
		map.put(emp2, 2);
		map.put(emp3, 3);
		
		System.out.println(map.size());
		System.out.println(map.get(emp4));
	}

	public final class Employee {
		private final int id;
		private final String name;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		/*@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			System.out.println("result: "+result);
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}*/

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		private HashMapTestWithImmutableObjects getOuterType() {
			return HashMapTestWithImmutableObjects.this;
		}		
		
	}
}
