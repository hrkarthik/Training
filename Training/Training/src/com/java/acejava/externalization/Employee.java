package com.java.acejava.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee extends Person implements Externalizable{

	public int id;
	public transient String department;
	
	public Employee() {
		System.out.println("in defalut constructor");
	}
	
	public Employee(int id, String department) {
		System.out.println("in arg constructor");
		this.id = id;
		this.department = department;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(department);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
		department = (String)in.readObject();
		
	}
}
