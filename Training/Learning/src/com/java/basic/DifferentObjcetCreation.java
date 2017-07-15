package com.java.basic;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class DifferentObjcetCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,3,4};
		
		
		try {
			Class<?> obj = Class.forName("com.java.basic.DifferentObjcetCreation");
			obj.newInstance();
			
			Class.class.getConstructors()[0].newInstance(args);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		List<String> list = new LinkedList<String>();
		Map<String, String> map = new HashMap<String, String>();
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedBlockingQueue<>();
		Map<String, String> treeMap = new LinkedHashMap<>();
		
		Set<String> set = new HashSet<>();
		Set<String> treeSet = new TreeSet<>();
	
		Arrays.sort(new int[5]);
		
	}

}
