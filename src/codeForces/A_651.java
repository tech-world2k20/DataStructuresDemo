package codeForces;

import java.util.Scanner;

public class A_651 {

	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while(t-- > 0) {
			int n = s.nextInt();

			if(n%2==0)
				System.out.println(n/2);
			else {
				int j = (n-1)/2;
				if(j>0)
				System.out.println(j);
				else System.out.println(1);
			}
		}
		s.close();
	}

	
		
}
