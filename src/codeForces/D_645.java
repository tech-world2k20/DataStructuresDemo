package codeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D_645 {

	public static void method(int[]  ar, int n, int x) {
		int sum=0;
		for (int i = 0; i < n; i++) 
			sum += ar[i];

		int[] A = new int[2*sum];
		int j=0;
		for (int i = 0; i < n; i++) {
			int cur = ar[i];
			for(int k=1; k<=cur; j++,k++) {
				A[j] = k;
			}
		}

		System.arraycopy(A, 0, A, sum, sum);
		int ans=0;
		for (int i = 0; i < x; i++) 
			ans += A[i];
		int max=ans;
		for(int i=x; i<2*sum; i++) {
			ans -= A[i-x];
			ans += A[i];
			if(ans > max)
				max = ans;
		}

		System.out.println(max);
	}

	public static String methodString(String a, String b) {

		char[] c =a.toCharArray();
		for(char i : c) {
			if(b.contains(i+""))
				return "Yes";
		}

		return "No";
	}

	/*
	public static void main(String[] args) {



		Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        s.next();
        while(n-- > 0){
            String a = s.nextLine();
            String b = s.nextLine();

            System.out.println(methodString(a, b));

        }        

/*
        2
        phackerekarthj
        jhakckerearthp
        hello
        buy
	       

	//		System.out.println(methodString("phackerekarthj", "jhakckerearthp"));
	//		System.out.println(methodString("", "jhakckerearthp"));
	//		System.out.println(methodString("buy", "hello"));

	//		Scanner s  = new Scanner(System.in);
	//		int n = s.nextInt();
	//		int x = s.nextInt();
	//
	//		int[] ar = new int[n];
	//		for (int i = 0; i < n; i++) 
	//			ar[i] = s.nextInt();
	//
	//		method(ar, n, x);
	//
	//
	//
	//
	//		s.close();

*/

static int[] ar;
static Map<Integer, Integer> map = new HashMap<>();
public static void main(String args[] ) throws Exception {

	Scanner s = new Scanner(System.in);
	int n = s.nextInt();  
	ar = new int[n];
	for(int i=0; i<n; i++){
		ar[i] = s.nextInt();
		if(map.get(ar[i]) == null) map.put(ar[i], getGCD(ar[i]));
	}
	
//	int query = s.nextInt();
	while(s.hasNextLine()) {
		String st = s.next();
		if(st.equals("C")) {
			int x = s.nextInt();
			int y = s.nextInt();
			compute(x,y);
		}
		else if(st.equals("U")) {
			int x = s.nextInt();
			int y = s.nextInt();
			update(x,y);
		}
	}
	
	s.close();

}

private static void update(int x, int y) {
	ar[x-1] = y;
	
	if(map.get(y)== null)
		map.put(ar[x-1], getGCD(y));
	
}

private static void compute(int x, int y) {
	int res=0;
	for(int i = x-1; i<=y-1; i++) {
		res += map.get(ar[i]);
	}
	
	res = (int) (res % (Math.pow(10,  9)+7));
	
	System.out.println(res);
	
}

private static Integer getGCD(int x) {
	int gcdValue=0;
	for(int i=1; i<=x; i++) {
		gcdValue += GCD(i, x);
	}
	return gcdValue;
}

public static int GCD(int a, int b){
	if(b==0) return a;

	return GCD(b, a%b);
}

}
/*
3
3 4 3
6
C 1 2
C 1 3
C 3 3
U 1 4
C 1 3
C 1 2

*/