package Searching;

import Sorting.SortingClass;



/**
 * given an array with both positive and negative elements, find two elements such that there sum is closest to ZERO.
 *
 */
public class TwoElementsWithMinSum {

	//brute force solution
	public static void method(int[] ar, int n) {
		int i,j,sum_min,sum,min_i = 0,min_j = 0;
		if(n < 2) return;
		sum_min=ar[0]+ar[1];
		for (i = 0; i < n; i++) 
			for ( j = i+1; j < n; j++) {
				sum = ar[i]+ar[j];
				if(Math.abs(sum_min) > Math.abs(sum)) {
					sum_min = sum;
					min_i=i;
					min_j=j;
				}
			}
		System.out.println("the two elements are :"+ar[min_i]+" and " +ar[min_j]);
		
	}
	
	static void methodUsingSorting(int[] ar, int n) {
		if(n < 2) return;
		SortingClass s = new SortingClass();
		s.MergeSort(ar, 0, n);
		int i=0,j=n-1,pSum=Integer.MAX_VALUE, nSum=Integer.MIN_VALUE;
		while(i<j) {
			int temp = ar[i]+ar[j];
			if(temp < 0) {
				if(temp > nSum) 
					nSum = temp;

				i++;
			}
			else if(temp > 0) {
				if(temp < pSum) 
					pSum = temp;
				
				j--;
			}
			else System.out.printf("closest sum : %d" , ar[i]+ar[j]);
		}
		System.out.println((Math.abs(nSum)>pSum? pSum : nSum));
		
	}
	
	
	public static void main(String[] args) {
		int[] ar = {7,60,-10,70,-80,85};
//		method(ar, ar.length);
		
		methodUsingSorting(ar, ar.length);
	}

}
