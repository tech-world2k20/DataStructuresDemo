package Searching;

import Sorting.SortingClass;



/**
 * given an array with both positive elements, find three elements such that there sum is K.
 */
public class ThreeElementsWithSumK {

	//brute force solution
	public static void bruteForceSearching(int[] ar, int n, int K) {
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				for (int k = 0; k < ar.length; k++) {
					if(ar[i] + ar[j]+ar[k] == K) {
						System.out.println("Items found at pos: i:"+i+" j:"+j+" k:"+k);
						return;
					}
				}
			}
		}
		System.out.println("No such elements");
	}
	
	static void methodUsingSorting(int[] ar, int n, int data) {
		SortingClass s = new SortingClass();
		s.MergeSort(ar, 0, n);
		for (int i = 0; i < n; i++) {
			for (int j = i+1,k=n-1; j < n; ) {
				if(ar[i]+ar[j]+ar[k] == data) {
					System.out.println("Items found at pos: i:"+i+" j:"+j+" k:"+k);
					return;
				}
				else if(ar[i]+ar[j]+ar[k] < data)
						j++;
				
				else k--;
			}
		}
		System.out.println("No such elements");
	}
	
	
	public static int NegativeBeforeKPositiveAfterK(int[] ar , int n, int low, int high) {
		int mid;
		
		while(low <= high) {
			//if array has size 1
			if(low == high)
				return ar[low];
			
			//if array has size 2
			else if(low == n-1)
				return Math.max(ar[low], ar[high]);
				
			else {
				mid = (low+high)/2;
				
				if(ar[mid-1] < ar[mid] && ar[mid] > ar[mid+1])
					return ar[mid];
				
				else if (ar[mid-1] < ar[mid] && ar[mid] < ar[mid+1]) 
					low = mid+1;
				
				else if (ar[mid-1] > ar[mid] && ar[mid] > ar[mid+1]) 
					high = mid-1;
				
				else return Integer.MIN_VALUE;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] ar = {7,60,-10,70,-80,85};

//		bruteForceSearching(ar, ar.length, 20);
		methodUsingSorting(ar, ar.length, -20);
		
		int[] arr = {-7,-5,-3,-1,88,334,339,45,34,22,0};
		
		int res = NegativeBeforeKPositiveAfterK(arr, arr.length, 0, arr.length-1);
		System.out.println(res);
	}

}
