package HackerEarth;

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        while(n-- > 0){
            String s1 = s.nextLine();
            String s2 = s.nextLine();

            method(s1, s2);
        }     
        s.close();
    }
    

    public static void method(String s1, String s2){
        int[] c = new int[26];

        for(int i=0; i< s1.length(); i++){
        	char ch = s1.charAt(i); 
            if( ch >= 'a' && ch <= 'z'){
            	int index = ch - 'a';
                c[index]++;
            }
        }

        for(int i=0; i< s2.length(); i++){
        	char ch = s2.charAt(i); 
            if( ch >= 'a' && ch <= 'z'){
            	int index = ch - 'a';
                c[index]--;
            }
        }
        int sumP=0, sumN=0;
        for(int i=0; i<c.length; i++){
            if(c[i] > 0)
            	sumP += c[i];
            else if(c[i] < 0)
            	sumN +=c[i];
        }

        if(sumP > 0 && sumN==0)
            System.out.println("You win some.");
        
        else if(sumN < 0 && sumP==0)
            System.out.println("You lose some.");

        else System.out.println("You draw some.");
    }
}

/*
 * 
3
i will win
will i
today or tomorrow
today or tomorrow and yesterday
i dare you
bad day

 * 
 */


