package com.acejava.usecases.callCenter;


	
	public class ProductManager extends Employee {

		   public ProductManager(int employeeLevel){
		      this.employeeLevel = employeeLevel;
		   }

		   @Override
		   protected void callReceived(String message) {		
		      System.out.println("Call Received by Product Manager : " + message);
		   }
		}


