package com.acejava.usecases.callCenter;

public class TechnicalLead extends Employee{
	
	public TechnicalLead(int employeeLevel){
	      this.employeeLevel = employeeLevel;
	   }

	   @Override
	   protected void callReceived(String message) {		
	      System.out.println("Call Received by Technical Lead : " + message);
	   }

}
