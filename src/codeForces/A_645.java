package codeForces;

import java.util.Scanner;

public class A_645 {
	
	public static void method(int x1,int y1,int x2 , int y2) {
		
		long  ans = (x2-x1) * (y2-y1) + 1;
		
		System.out.println(ans);
		
	}
/*  Input
	4
	1 1 2 2
	1 2 2 4
	179 1 179 100000
	5 7 5 7

*/		
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			
			method(x1, y1, x2, y2);
			
		}
		s.close();
	}
}
