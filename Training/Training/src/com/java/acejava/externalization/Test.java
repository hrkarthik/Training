package com.java.acejava.externalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	static Employee emp;
	static Employee empFromFile;
	
	public static void main(String[] args) {
		emp = new Employee(0, "java");
		write();
		read();
		
		System.out.println(empFromFile.id+empFromFile.department);
	}

	public static void write(){
		FileOutputStream fs;
		ObjectOutputStream os;
		try {
			fs = new FileOutputStream(new File("D:\\java\\kholal\\output\\employee.ser"));
			os = new ObjectOutputStream(fs);
			os.writeObject(emp);
			os.close();
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void read(){
		FileInputStream fs;
		ObjectInputStream os;		
		try {
			fs = new FileInputStream(new File("D:\\java\\kholal\\output\\employee.ser"));
			os = new ObjectInputStream(fs);
			empFromFile = (Employee) os.readObject();			
			os.close();
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
