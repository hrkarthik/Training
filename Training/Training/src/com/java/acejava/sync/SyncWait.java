package com.java.acejava.sync;

public class SyncWait {

	private static Object obj = new Object();
	
	public static void main(String[] args){
		SyncWait syncObj = new SyncWait();
		Thread t = new Thread(syncObj.new worker(syncObj));
		t.start();
	}

	private class worker implements Runnable{
		SyncWait syncObj;
		
		public worker(SyncWait syncObj) {
			this.syncObj = syncObj;
		}

		@Override
		public void run() {
			System.out.println("in run");
			try {
				syncObj.sync();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

public void sync() throws InterruptedException{
	synchronized(obj){
		System.out.println(" in sync");
		obj.wait(1000);
		System.out.println(" after sync");
	}
}

}
