package com.java.acejava.enums;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public enum EnumSingleton {

	INSTANCE(10,"Specimen");
	
	public final int i;
	
	public final String name;
	
	private EnumSingleton(int i, String name) {
		this.i = i;
		this.name = name;
	}
	
	private void readObject(ObjectInputStream in) throws IOException,
    ClassNotFoundException {
    throw new InvalidObjectException("can't deserialize enum");
	}
}
