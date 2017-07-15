package com.java.acejava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {

	public static void main(String[] args) {
		
		ScheduledExecutorService se = new ScheduledThreadPoolExecutor(3);
		ThreadPoolExecutor fx = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		Runnable task = null;
		fx.submit(task);
		fx.execute(task);
		//ThreadPoolExecutor sx = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
		ThreadPoolExecutor cx = (ThreadPoolExecutor) Executors.newCachedThreadPool();
				
		System.out.println(fx.getMaximumPoolSize());
		System.out.println(fx.getCorePoolSize());
		System.out.println(cx.getMaximumPoolSize());
		System.out.println(cx.getCorePoolSize());
		
		//System.out.println(sx.getMaximumPoolSize()+sx.getCorePoolSize());
	}

}
