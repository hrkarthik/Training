package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasic {

	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		StreamBasic obj = new StreamBasic();
		add(100);
		
		list.forEach(obj::print);
		
		Stream<Integer> listStream = list.stream();
		long count = listStream
					.filter(x -> {
						if(x>95)
						System.out.println();
						return false;
						})
					.count();		
			
		list.stream().filter(x -> {
			System.out.println("x");
			return false;
			}).findFirst();
		
		//list.stream().max();
		System.out.println("count: "+count);
	}

	public static void add(int n){
		for(int i = 0; i<n; i++){
			list.add(i);
		}
	}
	
	public void print(int value){
		System.out.println(value);
	}
}
