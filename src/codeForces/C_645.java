package codeForces;

import java.util.Arrays;
import java.util.Scanner;

public class C_645 {
	
	public static void method(int[]  ar, int n) {
		Arrays.sort(ar);
		int sum = 1;
		for (int i = 0; i < n; i++) {
			if(ar[i] <= i+1)
				sum = i+2;
		}
		
		System.out.println(sum);
		
	}
//  Input
//	4
//	5
//	1 1 2 2 1
//	6
//	2 3 4 5 6 7
//	6
//	1 5 4 5 1 9
//	5
//	1 2 3 5 6
		
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < n; i++) 
				ar[i] = s.nextInt();
			
			method(ar, n);
		}
		s.close();
	}
}
