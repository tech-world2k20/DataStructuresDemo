package Searching;

public class BinarySearch {

	public int BinarrySearchRecursive(int[] ar, int low, int high, int data) {

		int mid= (low+high)/2;

		if(ar[mid] == data) return mid;

		else if(ar[mid] < data) 
			return BinarrySearchRecursive(ar, mid+1, high, data);

		else 
			return BinarrySearchRecursive(ar, low, mid-1, data);
	}

	public int BinarrySearchIterative(int[] ar, int n, int data) {
		int low=0, high=n-1;
		while (low<=high) {
			int mid = (low+high)/2;
			if(ar[mid] == data) return mid;
			
			else if(ar[mid] < data)
				low = mid+1;
			
			else high = mid-1;
		}
		
		return -1;
	}

}
