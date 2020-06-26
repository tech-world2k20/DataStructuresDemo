package Searching;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import Sorting.SortingClass;

public class CheckDuplicateSorting {

	public static void method(int[] ar) {
		SortingClass s = new SortingClass();
		s.MergeSort(ar, 0, ar.length);
		
		
		for (int i = 1; i < ar.length; i++) {
			if(ar[i-1] == ar[i]) {
				System.out.println("duplicate exist:" +ar[i-1]);
				return;
			}
		}
	}
	
	private static void methodUsingHashtable(int[] ar) {
		Hashtable<Integer, Integer> h = new Hashtable<>();
		
		for (int i = 0; i < ar.length; i++) {
			if(h.contains(ar[i])) {
				System.out.println("duplicate exist:" +ar[i]);
				break;
			}
			else 
			h.put(i, ar[i]);
		}
		
	}
	
	private static void methodUsingSet(int[] ar) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < ar.length; i++) {
			if(set.contains(ar[i])) {
				System.out.println("duplicate exist:" +ar[i]);
				break;
			}
			else 
			set.add(ar[i]);
		}
	}

	private static void methodUsingNegation(int[] ar) {
		
		for (int i = 0; i < ar.length; i++) {
			if(ar[Math.abs(ar[i])] < 0) {
				System.out.println("duplicate exist:" + Math.abs(ar[i]));
				return;
			}
			else ar[Math.abs(ar[i])] = -ar[Math.abs(ar[i])]; 
		}

		System.out.println("No duplicate in given array");
	}

	public static void main(String[] args) {
		int[] ar = {1,8,4,6,2,3,5,7,9,3};

		method(ar);
		
//		methodUsingHashtable(ar);
		
//		methodUsingSet(ar);
		
		//elements must be in range from 0 - n-1
//		methodUsingNegation(ar);
	}


}
