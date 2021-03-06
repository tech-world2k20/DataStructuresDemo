package Searching;

/**
 *    Given a sorted array posibbly with duplicates. find the last occurence of element K
 *   Time = O(logn)    Space= O(1)
 */
public class LastOccurenceOfK {
	
	public static int lastOccurence(int[] ar, int low, int high, int data) {
		int mid;
		while (low <= high) {
			mid = (low+high)/2;
			if(high == mid && ar[mid]==data || ar[mid]==data && ar[mid+1] >data) {
				System.out.println("first occurence of K is at :"+mid);
				return mid;
			}
			else if (ar[mid] < data) 
				low = mid+1;
			
			else high = mid-1;
		}
		
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int[] ar = {-2,0,1,5,5,7,7,9,13,13,13,15,17,90};
		lastOccurence(ar, 0, ar.length-1, 7);

	}

}
