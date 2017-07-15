package com.acejava.usesases;

public class RentrantLockUser {

	public static RentrantLockExample rentrantLock = new RentrantLockExample();
	//public static NonRentrantLockExample rentrantLock = new NonRentrantLockExample();
	
	public static void main(String[] args) throws InterruptedException {
		RentrantLockUser user = new RentrantLockUser();
		Thread runner = new Thread(user.new worker());
		runner.start();
		
		/*Thread.sleep(10);
		System.out.println("Doing unlock");								
		rentrantLock.unlock();	
		rentrantLock.unlock();	*/
	}

	private class worker implements Runnable{

		public void run() {
			try {
				System.out.println("getting first lock");
				rentrantLock.lock();				
				System.out.println("getting Second lock");
				rentrantLock.lock();				
				rentrantLock.unlock();
				rentrantLock.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
