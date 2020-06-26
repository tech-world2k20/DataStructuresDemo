package codeForces;

import java.util.Scanner;

public class A_649 {
	
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int x = s.nextInt();
			int[] ar = new int[n];
			long sum=0;
			for(int i=0; i<n; i++) {
				ar[i] = s.nextInt();
				sum += ar[i];
			}
			
			System.out.println(method(ar, n, sum, x));
		}
		s.close();
	}

	private static int method(int[] ar, int n, long sum, int x) {
		if(sum % x != 0)
			return n;
		int start=0, end=n-1;
		int count=0;
		while(sum % x == 0 && start<=end) {
			if(ar[start] % x != 0) {
				sum -= ar[start];
				start++;
			}else if(ar[end] % x != 0) {
				sum -= ar[end];
				end--;
			}
			else {
				sum -=ar[start];
				start++;
			}
			count++;
		}
		if(sum != 0)
			return n-count;
		
		return -1;
	}

}
