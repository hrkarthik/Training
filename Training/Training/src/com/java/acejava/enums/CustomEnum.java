package com.java.acejava.enums;

public final class CustomEnum {

	public static final CustomEnum SUNDAY;
	public static final CustomEnum MONDAY;
	
	private final int ordinal;
	private final String name;
	
	public String customParameter;
	
	public int getOrdinal() {
		return ordinal;
	}


	public String getName() {
		CustomEnum.class.getClassLoader();
		//   Class.forname();
		return name;		
	}	
	
	private CustomEnum(int ordinal, String name, String customParameter){
		this.ordinal = ordinal;
		this.name = name;
		this.customParameter = customParameter;		
	}
	
	static{
		SUNDAY = new CustomEnum(0, "SUNDAY", "firstDay");
		MONDAY = new CustomEnum(1, "MONDAY", "secondDay");
	}
	
	public String toString(){
		return getName();		
	}
}
