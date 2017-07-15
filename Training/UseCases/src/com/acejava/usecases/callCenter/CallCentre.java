package com.acejava.usecases.callCenter;

public class CallCentre {
	
	 private static Employee getChainOfEmployee(){

		   Employee fresher = new Fresher(Employee.FRESHER_LEVEL);
		   Employee lead = new TechnicalLead(Employee.TEAM_LEAD_LEVEL);
		   Employee manager = new ProductManager(Employee.PRODUCT_MANAGER_LEVEL);

	      fresher.setNextContactPoint(lead);
	      lead.setNextContactPoint(manager);

	      return fresher;	
	   }

	   public static void main(String[] args) {
		   String customerMsg = "Customer Message";
		   Employee employeeChain = getChainOfEmployee();

		   employeeChain.callReceivedCallCenter(customerMsg);

		   employeeChain.callReceivedCallCenter(customerMsg);

		   employeeChain.callReceivedCallCenter(customerMsg);
	   }

}
