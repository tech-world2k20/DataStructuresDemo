
public class gcdExtended {
	
	public static int extendedGCD(int a, int b, int[] ar) {
		if(a==0) {
			ar[0] = 0;
			ar[1] = 1;
			return b;
		}
		
		int[] t  = {1,1};
		int gcd = extendedGCD(b%a, a, t);
		
		ar[0] = t[1] - (b/a)*t[0];
		ar[1] = t[0];

		return gcd;
	}
	
	public static int gcd(int a, int b) {
		if(a==0)
			return b;
		
		return gcd(b%a,  a);
	}

	public static void main(String[] args) {
		int x=1, y=1; 
        int a = 3, b = 4;
        int[] ar = {x, y};
        int gr = extendedGCD(a, b, ar);
        System.out.println("gcd(" + a +  " , " + b+ ") = " + gr);
     	System.out.println("Coefficents are : x="+ar[0]+ "  y="+ar[1]);
     	System.out.println(gcd(a, b));
     	
		
	}

}
