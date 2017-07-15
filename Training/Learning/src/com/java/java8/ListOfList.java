package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfList {

	public static void main(String[] args) {
		List<List<String>> listoflists = new ArrayList<>();
		String[] sl1="jdksajdksajdsad".split("");
		String[] sl2="jdksajdksajdsad".split("");
		listoflists.add(Arrays.asList(sl1));
		listoflists.add(Arrays.asList(sl2));
		
		//listoflists.stream().forEach(l -> l.stream().forEach(System.out::println));
		
		//listoflists.stream().flatMap(li -> li.stream()).forEach(System.out::println);
		
		//listoflists.stream().flatMap(li -> li.stream()).sorted((i,j) -> j.compareTo(i)).forEach(System.out::println);
	
		listoflists.stream().flatMap(li -> li.stream()).sorted(Collections.reverseOrder()).forEach(System.out::println);
		
	//	listoflists.stream().flatMap(li -> li.stream()).collect().forEach(System.out::println);
		
		
	}

}
