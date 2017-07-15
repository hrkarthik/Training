package com.acejava.usecases.callCenter;
import java.util.concurrent.Executor;

import java.util.Scanner;

public abstract class Employee {
	   public static int FRESHER_LEVEL = 1;
	   public static int TEAM_LEAD_LEVEL = 2;
	   public static int PRODUCT_MANAGER_LEVEL = 3;

	   public int employeeLevel;

	   //next element in chain or responsibility
	   protected Employee nextEmployee;

	   public void setNextContactPoint(Employee nextEmployee){
	      this.nextEmployee = nextEmployee;
	   }

	   public void callReceivedCallCenter(String message){
		   callReceived(message);
		   
		   System.out.println("To finish the call press Y or to transfer call press N");
		   Scanner sc = new Scanner(System.in);
		   String str = sc.nextLine();
		  
	      if(str.equals("N") && nextEmployee != null){
	    	  nextEmployee.callReceivedCallCenter(message);
	      }else{
	    	  System.out.println("Thanks for Calling");
	      }
	   }

	   abstract protected void callReceived(String message);
		
	}