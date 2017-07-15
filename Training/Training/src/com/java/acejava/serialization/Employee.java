package com.java.acejava.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
		
	public Employee(int id, String name){
		System.out.println("IN CONSTRUCTOR EMPLOYEE");
		this.id = id;
		this.name = name;
	}
	
	public Employee(){
		System.out.println("IN CONSTRUCTOR EMPLOYEE DEFAULT");
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("IN write object");
        out.defaultWriteObject();
        out.writeObject(this);
    }

    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
    	System.out.println("In read object");
    	in.defaultReadObject();
    	in.readObject();
    }
}

