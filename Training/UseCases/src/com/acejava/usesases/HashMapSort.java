package com.acejava.usesases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSort {

	public static void main(String[] args) {
		System.out.println("HashMap sorting by value demo");
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		HashMapSort hashMapSort = new HashMapSort();
		
		hashMap.put(1, "one");
		hashMap.put(2, "two");
		hashMap.put(3, "two");
		hashMap.put(4, "four");
		hashMap.put(6, "six");
		
		List<Entry<Integer, String>> entryList =  new ArrayList<Entry<Integer, String>> (hashMap.entrySet());
		System.out.println("Value before sorting");
		for(Entry<Integer, String> entry: entryList){
			System.out.println(entry.getValue());
		}
		
		Collections.sort(entryList, hashMapSort.new valueSort());
		for(Entry<Integer, String> entry: entryList){
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		System.out.println("Value after sorting");
		Set<Entry<Integer, String>> linkedEntryList = linkedHashMap.entrySet();
		for(Entry<Integer, String> entry: linkedEntryList){
			System.out.println(entry.getValue());
		}
	}

	private class valueSort implements Comparator<Entry<Integer, String>>{

		public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {		
			return o1.getValue().compareTo(o2.getValue());
		}

	}
}
