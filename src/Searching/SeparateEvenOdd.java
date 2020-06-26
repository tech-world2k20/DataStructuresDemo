package Searching;

/**
 *	Given an array, writhe a function that put all even numbers first and the odd numbers
 *	(variation of Dutch National Flag problem)
 *	Time = O(n)    Space= O(1)
 */
public class SeparateEvenOdd {

	
//	logic similar to Quick Sort
	static void EvenOdd(int[] ar, int n) {
		int low=0, high=n-1;
		
		while(low<high) {
			
			while (ar[low]%2==0 && low<high) 
				low++;
			
			while (ar[high]%2==1 && low<high) 
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
		int[] ar = {1,5,3,7,44,3,6,89,43,2,0};
		
		EvenOdd(ar, ar.length);
		
	}

}
