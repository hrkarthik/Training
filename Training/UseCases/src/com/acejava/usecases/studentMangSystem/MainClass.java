package com.acejava.usecases.studentMangSystem;

public class MainClass {

	public static void main(String[] args) {
		
			 
		StudentDataAccessInterface studentDao = new StudentData();

			      //print all students
			      for (Student student : studentDao.getAllStudents()) {
			         System.out.println("Student: [RollNo : " + student.getRollno() + ", Name : " + student.getName() + " ]" + ", CLass Name : " + student.getClass() + " ]");
			      }


			      //update student
			      Student student =studentDao.getAllStudents().get(0);
			      student.setName("Michael");
			      studentDao.updateStudent(student);

			      //get the student
			      studentDao.getStudent(0);
			      System.out.println("Student: [RollNo : " + student.getRollno() + ", Name : " + student.getName() + " ]");		
			   }
			

	}


