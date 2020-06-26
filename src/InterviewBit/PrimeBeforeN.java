package InterviewBit;

public class PrimeBeforeN {
	
	static int[] primeBeforeN(int n) {
		boolean[] prime = new boolean[n+1];
		for (int i = 0; i < n; i++) 
			prime[i] = true;
		
		prime[0] = prime[1] = false;
		for(int p=2; p*p < n; p++) {
			if(prime[p] == true) {
				for (int i = p*p; i <= n; i +=p) 
					prime[i] = false;
			}
		}
			
		int count=0;
		for (int i = 2; i <=n; i++) {
			if(prime[i] == true) {
//				System.out.print(i +" ");
				count++;
			}
		}
		
//		System.out.println("\nno. of prime factors = " +count);
		int[] res = new int[count];
		int index=0;
		for(int i=0; i<n+1; i++){
		    if(prime[i] == true){
		        res[index++] = i;
		    }
		        
		}
        return res;
	}
	
	
	public static void main(String[] args) {
		
		int n = 10;
		int[] res = primeBeforeN(n);
		for(Integer i: res) {
			System.out.print(i+" ");
			}
		}

}
