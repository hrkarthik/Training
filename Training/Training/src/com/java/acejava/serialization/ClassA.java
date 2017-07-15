package com.java.acejava.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClassA  implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	int i = 10;
	int j = 20;
	ClassB b = new ClassB();
	
	public ClassA() {
		System.out.println("in classA");
	}
	
	public static void main(String[] args) {
		/*ClassA a1 = new ClassA();
		serEnum(a1);*/		
		ClassA obj = (ClassA) deSerEnum();
		System.out.println("i:"+obj.i);
		//System.out.println("i:"+a1.i);
		System.out.println("j:"+obj.j);
	}

	public static void serEnum(ClassA value){
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream(new File("D:\\java\\kholal\\output\\example.ser"));
			os = new ObjectOutputStream(fs);
			//i = 20;
			//value.j = 10;
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
	
	public static Object deSerEnum(){
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
}
