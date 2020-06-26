package Searching;

import java.util.HashMap;
import java.util.Hashtable;

import Sorting.SortingClass;

public class ArrayWithGivenSumOFTwo {

	/**
	 * find 2 elements in array whose sum is equals to K
	 */

	public static void method(int[] ar, int n, int k) {
		SortingClass s = new SortingClass();
		s.MergeSort(ar, 0, n);
		int i,j;
		for(i=0, j=n-1; i<j;) {
			if(ar[i] + ar[j] == k) {
				System.out.println("Items found at i:"+i +"  j:"+j);
				i++;
				j = n-1;
			}

			else if(ar[i] + ar[j] < k)
				i++;

			else j--;
		}
	}


	public static void methodUsingHashTable(int[] ar, int k) {
		HashMap<Integer, Integer> hmap = new HashMap();
		for (int i = 0; i < ar.length; i++) 
			hmap.put(i, ar[i]);

		for (int i = 0; i < ar.length; i++) {
			if(hmap.containsValue((k-ar[i]))) 
				System.out.println("Items found ");
			return;
		}
	}




	public static void main(String[] args) {
		int[] ar = {1,8,4,6,2,3};

		method(ar, ar.length, 7);

		methodUsingHashTable(ar, 7);

	}


}
