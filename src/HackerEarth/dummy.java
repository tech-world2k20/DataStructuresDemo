package HackerEarth;

import java.util.Scanner;

public class dummy {

    public static int BubbleSort(int[] ar, int n){
        int count=0;
        boolean swapped=true;
        while(swapped != false){
            swapped = false;
            count++;
            for(int i=0; i<n-1; i++){
                if(ar[i] > ar[i+1]){
                    swap(i, i+1, ar);
                    swapped = true;
                }
            }
        }
        return count;
    }

    public static void swap(int ithIndex, int jthIndex, int[] ar){
        int temp = ar[ithIndex];
        ar[ithIndex] = ar[jthIndex];
        ar[jthIndex]=temp;
    }
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();  
        int[] ar = new int[n];
        for(int i=0; i<n; i++)
            ar[i] = s.nextInt();
        
        int res = BubbleSort(ar, n);
        System.out.println(res);
        
        s.close();

    }
}
