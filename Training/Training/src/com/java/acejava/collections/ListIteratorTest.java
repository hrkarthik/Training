package com.java.acejava.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIteratorTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		//list.add(3);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());		
			list.remove(1);
		}
	}	
}
