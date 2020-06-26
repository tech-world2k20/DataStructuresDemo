package HackerEarth;

import java.util.Scanner;

public class greatestOddDivisor {

    public static void main(String args[] ){

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();  
        
        for(int i=0; i<t; i++){
            long n = s.nextLong();
            int m = s.nextInt();
            method(n , m);
        }
        s.close();
    }
    public static void method(long n, int m) {
        long sum=0;
        for(long i=1; i<=n; i++){
            sum += gOddDivisor(i);
            if(sum > m)
            sum %= m;
        }

        System.out.println(sum);
    }
    public static long gOddDivisor(long i){
        if(i % 2 != 0)
            return i;
        
        else{
        	while(i % 2 == 0 ) {
        		i /=2;
        	}
            return i;
        }
    }
}

/*
 5
1 100
110 30
12345 100000007
10 28383
100 5

*/
