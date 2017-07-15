package com.java.acejava.system;

public class ShutdownHook {	

	static ShutdownHook obj;
	public static void main(String[] args) {
		obj = new ShutdownHook();

		System.out.println("in before halt");

		CustomSecurityManager securityManger = obj.new CustomSecurityManager();
		System.setSecurityManager(securityManger);
		
		//registerForHook();

		Runtime.getRuntime().halt(1);
		Runtime.getRuntime().exit(0);

		System.out.println("in after halt");	

	}

	public static void registerForHook(){
		Runtime.getRuntime().addShutdownHook(new Thread(obj.new Hook()));
	}

	class Hook implements Runnable{			

		@Override
		public void run() {
			System.out.println("in runnable hook");

		}
	}
	
	class CustomSecurityManager extends SecurityManager{
		
		public void checkExit(int status){
			super.checkExit(status);
			throw new SecurityException("Not allowed."+status);
		}
	}
}
