package com.java.acejava.enums;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumSerialization {

	public static void main(String[] args) {
		EnumSerialization obj = new EnumSerialization();
		
		obj.serEnum(EnumSingleton.INSTANCE);
		
		EnumSingleton singleton = (EnumSingleton)obj.deSerEnum();
		System.out.println(singleton.i);
		System.out.println(singleton.name);
		System.out.println(singleton);
		System.out.println(singleton.ordinal());
	}

	public void serEnum(EnumSingleton value){
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream(new File("D:\\java\\kholal\\output\\enum.ser"));
			os = new ObjectOutputStream(fs);
			os.writeObject(value);
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
		try (FileInputStream fs = new FileInputStream(new File("D:\\java\\kholal\\output\\enum.ser"));
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
}
