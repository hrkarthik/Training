package com.java.acejava.concepts;

import java.util.ArrayList;
import java.util.Collections;

public final class ImutableClass {

	private final int id;
	
	private final String name;
	
	private final ArrayList<Integer> list;
	
	private final Object obj;
	
	public ImutableClass(int id, String name, ArrayList<Integer> list, Object obj) {
		this.id = id;
		this.name = name;
		this.list = list;
		this.obj = obj;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Integer> getList() {
		return (ArrayList<Integer>) Collections.unmodifiableList(list);
	}

	public Object getObj() {
		return obj;
	}		
	
}
