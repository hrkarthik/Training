package com.acejava.usecases.callCenter;

public class Fresher extends Employee {

	   public Fresher(int employeeLevel){
	      this.employeeLevel = employeeLevel;
	   }

	   @Override
	   protected void callReceived(String message) {		
	      System.out.println("Call Received by Fresher : " + message);
	   }
	}

