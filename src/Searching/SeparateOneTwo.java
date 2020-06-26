package Searching;

/**
 *	Given an array, writhe a function that put all 0 first and then 1
 *	(variation of Dutch National Flag problem)
 *	Time = O(n)    Space= O(1)
 */
public class SeparateOneTwo {

	
//	logic similar to Quick Sort
	static void ZeroOne(int[] ar, int n) {
		int low=0, high=n-1;
		
		while(low<high) {
			
			while (ar[low]==0 && low<high) 
				low++;
			
			while (ar[high]==1 && low<high) 
				high--;
			
			if(low < high) {
				int temp = ar[low];
				ar[low] = ar[high];
				ar[high] = temp;
				
				low++;
				high--;
			}
			
		}
		for (int i : ar) 
			System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		int[] ar = {1,1,0,0,1,1,0,0,0,0,1,1,0};
		
		ZeroOne(ar, ar.length);
		
	}

}
