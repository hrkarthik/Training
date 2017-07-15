package com.java.acejava.classloader;

public class ClassA {

	private int id;
	
	private ClassA Instance = null;
	
	private ClassA(int id) {
		this.id = id;
	}
	
	public ClassA getInstance(){		
		if(null != Instance){
			synchronized(ClassA.class){
				if(null != Instance)
					return new ClassA(1);
			}		
		}
		return Instance;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
