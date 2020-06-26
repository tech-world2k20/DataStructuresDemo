
public class NthFibonacciNo {
	
	//recursion 
	public static int method1(int n) {
		if(n <= 1)
			return n;
		
		return method1(n-1) + method1(n-2);
	}
	
	//using DP (array)
	public static int method2(int n) {
		
		int[] ar = new int[n+2];
		ar[0] = 0;
		ar[1] = 1;
		for (int i = 2; i < ar.length; i++) {
			ar[i] = ar[i-1] + ar[i-2];	
		}
		
		return ar[n];
	}
	
	//space optimized method 2
	public static int method3(int n) {
		int a=0, b=1,c;
		if(n == 0)
			return a;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	//using power of matrix
	public static int method4(int n) {
		int[][] f = new int[][] {{1,1},{1,0}};
		if(n == 0)
			return 0;
		power(f , n-1);
		
		return f[0][0];
	}
	private static void power(int[][] f, int n) {
		
		int j;
		int[][] m = new int[][] {{1,1},{1,0}};
		
		for (j = 2; j <=n; j++) 
			multiply(f,m);
	}

	private static void multiply(int[][] f, int[][] m) {
		int w= f[0][0]*m[0][0] + f[0][1]*m[1][0];
		int x= f[0][0]*m[0][1] + f[0][1]*m[1][1];
		int y= f[1][0]*m[0][0] + f[1][1]*m[1][0];
		int z= f[1][0]*m[0][1] + f[1][1]*m[1][1];
		
		f[0][0] = w;
		f[0][1] = x;
		f[1][0] = y;
		f[1][1] = z;
	}
	
	//using formula
	public static int method5(int n) { 
		double phi = (1 + Math.sqrt(5)) / 2; 
		return (int) Math.round(Math.pow(phi, n)  
		                        / Math.sqrt(5)); 
	}
	
	//fast doubling method
/*	F2n-1 = (Fn)2  + (Fn-1)2
	F2n = (Fn-1 + Fn+1)Fn = (2Fn-1 + Fn)Fn
	To get the formula to be proved, we simply need to do the following
	If n is even, we can put k = n/2
	If n is odd, we can put k = (n+1)/2
*/
	static int f[];
	public static int method6(int n) {
		
		if(n == 0)
			return 0;
		if(n==1 || n==2)
			return f[n] = 1;
		
		if(f[n] != 0)
			return f[n];
		
		int k = (n & 1) == 1 ? (n+1)/2 : n/2;
		
		f[n] = (n&1)==1? (method6(k)*method6(k)+method6(k-1)*method6(k-1)) : 
						 ((2*method6(k-1)+method6(k))*method6(k));
		return f[n];
	}

	public static void main(String[] args) {

		int n = 26;
		System.out.println(method1(n));
		System.out.println(method2(n));
		System.out.println(method3(n));
		System.out.println(method4(n));
		System.out.println(method5(n));
		f = new int[1000];
		System.out.println(method6(n));

	}

}
