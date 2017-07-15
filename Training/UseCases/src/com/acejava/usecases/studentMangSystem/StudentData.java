package com.acejava.usecases.studentMangSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentData implements StudentDataAccessInterface ,StudentPerformanceReport{
	
	
		   //list is working as a database
		   List<Student> students;
		   ArrayList<Subjects> subj = new ArrayList<Subjects>();

		   public StudentData(){
		      students = new ArrayList<Student>();
		      Student student1 = new Student("Ram",0,ClassStand.FIRST.getName(),getSubj());
		      Student student2 = new Student("Mohan",1,ClassStand.SECOND.getName(),getSubj());
		      students.add(student1);
		      students.add(student2);		
		   }
		   @Override
		   public void deleteStudent(Student student) {
		      students.remove(student.getRollno());
		      System.out.println("Student: Roll No " + student.getRollno() + ", deleted from database");
		   }

		   //retrive list of students from the list
		   @Override
		   public List<Student> getAllStudents() {
		      return students;
		   }

		   @Override
		   public Student getStudent(int rollNo) {
		      return students.get(rollNo);
		   }

		   @Override
		   public void updateStudent(Student student) {
		      students.get(student.getRollno()).setName(student.getName());
		      System.out.println("Student: Roll No " + student.getRollno() + ", updated in the database");
		   }
		   
		   public ArrayList< Subjects> getSubj(){
			   subj.add((Subjects.CHEMISTRY));
			return subj;
			   
		   }
		   
		   
		@Override
		public int caluculatePerformance() {
			// TODO Auto-generated method stub
			return 0;
		}
		}

