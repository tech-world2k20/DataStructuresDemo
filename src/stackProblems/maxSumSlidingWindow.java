package stackProblems;

public class maxSumSlidingWindow {

	static void printKMax(int a[], int n, int k) 
	{ 
	    // If k = 1, print all elements 
	    if (k == 1) { 
	        for (int i = 0; i < n; i += 1) 
	            System.out.print(a[i]+ " "); 
	        return; 
	    } 
	   
	    // Using p and q as variable pointers 
	    // where p iterates through the subarray 
	    // and q marks end of the subarray. 
	    int p = 0, 
	        q = k - 1, 
	        t = p, 
	        max = a[k - 1]; 
	   
	    // Iterating through subarray. 
	    while (q <= n - 1) { 
	   
	        // Finding max 
	        // from the subarray. 
	        if (a[p] > max) 
	            max = a[p]; 
	   
	        p += 1; 
	   
	        // Printing max of subarray and shifting pointers to next index. 
	        if (q == p && p != n) { 
	            System.out.print(max+ " "); 
	            q++; 
	            p = ++t; 
	   
	            if (q < n) 
	                max = a[q]; 
	        } 
	    } 
	} 
	   
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int k =3;
		printKMax(arr, arr.length, k);
	}

}
