package com.acejava.usecases.studentMangSystem;

import java.util.ArrayList;





public class Student {
	
	private String name;
	private int rollno;
	private String classstd;
	private ArrayList<Subjects> sub;
	
	public Student(String name , int rollno , String classstd ,ArrayList<Subjects> sub){
		this.name = name;
		this.rollno = rollno;
		this.classstd =  ClassStand.class.getName();
		this.sub = sub;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	

}
