package com.java.acejava.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample{

	/**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;*/

	public SerializationExample() {
		System.out.println("IN CONSTRUCTOR SerializationExample DEFAULT");
	}
	
	public static void main(String[] args) {
		SerializationExample obj = new SerializationExample();
		Employee emp = new Employee(10,"test");
		//obj.serEnum(emp);
		
		Employee value = (Employee)obj.deSerEnum();
		System.out.println(value.id);
	}

	public void serEnum(Employee value){
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream(new File("D:\\java\\kholal\\output\\example.ser"));
			os = new ObjectOutputStream(fs);
			os.writeObject(value);
			//os.writeInt(value.id);
			//os.writeObject(value.name);
		} catch (IOException e1) {			
			e1.printStackTrace();
		} finally{
			try {
				if(fs!=null)
					fs.close();
				if(os!=null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public Object deSerEnum(){
		Object value = null;
		try (FileInputStream fs = new FileInputStream(new File("D:\\java\\kholal\\output\\example.ser"));
				ObjectInputStream os = new ObjectInputStream(fs);){			
			value = os.readObject();			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return value;
	}
	
	/*class Employee implements Serializable{
		*//**
		 * 
		 *//*
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
	}*/
}
