package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringManuplation {

	public static void main(String[] args) {
		StringManuplation obj = new StringManuplation();
		//System.out.println(obj.reverseString("abcdef"));
		//System.out.println(obj.checkPalindrome("abcbam"));
		//obj.printPermutation("abcde");
		//System.out.println(obj.checkAnagram("abcd", "bcdaa"));
		//System.out.println(Arrays.toString(obj.printAllPalindromes("abbaalla").toArray()));
		System.out.println(Arrays.toString(obj.printPermutationRecurssion("abc").toArray()));
	}

	public String reverseString(String specimen){
		String result = "";		
		System.out.println(specimen);

		if(null == specimen || specimen.length() == 1)
			return specimen;

		result = result + reverseString(specimen.substring(1))+specimen.charAt(0);

		return result;

	}

	public boolean checkPalindrome(String specimen){
		int length = specimen.length()-1;
		int index = 0;
		for(int i=length; i>length/2 ; i--){
			if(specimen.charAt(i) != specimen.charAt(index))
				return false;
			index++;
		}

		return true;
	}

	public boolean checkAnagram(String s, String t){
		if (s.length() != t.length()) return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0) ++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;


	}

	//Yet to implement
	public void printPermutation(String specimen){
		char[] array = specimen.toCharArray();
		for(int i = 0; i<array.length; i++){
			for(int j = 0; j<array.length; j++){
				if(i != j){
					char[] temp = Arrays.copyOf(array, array.length);
					char c1 = temp[i];
					temp[i] = temp[j];
					temp[j] = c1;
					System.out.println(new String(temp));
				}
			}
		}
	}
	
	public ArrayList<String> printPermutationRecurssion(String specimen){
		ArrayList<String> list = new ArrayList<>();
		if(null == specimen)
			return null;
		if(0 == specimen.length()){
			list.add("");
			return list;
		}
			
		char c = specimen.charAt(0);
		String remainder = specimen.substring(1);
		ArrayList<String> words = printPermutationRecurssion(remainder);
		for(String s : words){
			for(int i = 0; i<=s.length(); i++){
				String substringA = s.substring(0, i);
				String substringB = s.substring(i);				
				list.add(substringA + c + substringB);
			}
		}
		System.out.println(list.size());
		return list;
	}
	
	public Set<CharSequence> printAllPalindromes(String input) {
	    if (input.length() <= 2) {
	        return Collections.emptySet();
	    }
	    Set<CharSequence> out = new HashSet<CharSequence>();
	    int length = input.length();
	    for (int i = 1; i <= length; i++) {
	        for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
	            if (input.charAt(j) == input.charAt(k)) {
	                out.add(input.subSequence(j, k + 1));
	            } else {
	                break;
	            }
	        }
	    }
	    return out;
	}
}
