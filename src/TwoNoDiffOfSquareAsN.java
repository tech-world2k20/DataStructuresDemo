
public class TwoNoDiffOfSquareAsN {

	public static void main(String[] args) {

		int n = 64;
		method(n);
	}

	public static void method(int n) {
		for (int i = 1; i < Math.sqrt(n); i++) {
			if(n%i == 0) {
				int small = i;
				int big = n/i;
				
				if(small%2 == big%2) {
					int a = (small + big)/2;
					int b = (big-small)/2;
					System.out.println(a +" "+b);
					return ;
				}
			}
		}
		
		System.out.println("-1");
	}

}
