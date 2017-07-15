package com.java.acejava.enums;

import java.util.Arrays;

public class EnumUser {

	public static void main(String[] args) {
		/*System.out.println(EnumSingleton.INSTANCE.i);
		System.out.println(EnumSingleton.INSTANCE.name);
		
		System.out.println(EnumSingleton.INSTANCE);
		System.out.println(EnumSingleton.INSTANCE.ordinal());*/
		
		EnumDays[] value = EnumDays.values();
		System.out.println(Arrays.toString(value));
						
		/*setEnum(22,"kholal");		
		System.out.println(EnumSingleton.INSTANCE.i);*/
	}
	
	/*public static void setEnum(int id, String name){
		EnumSingleton.INSTANCE.i = id;
		EnumSingleton.INSTANCE.name = name;
	}*/
}
