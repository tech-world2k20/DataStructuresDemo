package HackerEarth;

import java.util.Stack;

public class TataCliq {

	public static int maxPower(int[] H, int[] P, int n) {
		int sum=0;
		for (int i = 0; i < n-1; ) {
			int j=i;
			int sumO=0, sumE=0;
			if(H[i] != H[i+1]) {
				sumO = P[i];
				i++;
			}else {
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(P[j]);
				stack.push(P[j+1]);
				j++;
				while(j+1<n && H[j] == H[j+1]) {
					stack.push(P[j+1]);
					j++;
				}
				while(!stack.isEmpty()) {
					sumO += stack.pop();
					if(!stack.isEmpty())
						sumE += stack.pop();
				}
				i=j+1;
			}
			sum += sumE > sumO ? sumE : sumO;

		}
		return sum;
	}

	public static void main(String[] args) {
		int[] H = {15,15,12,13,13,13,1,1,1,1};
		int[] P = {20,30,15,16,12,1,23,24,1,2};
		System.out.println("code started");
		int res = maxPower(H, P, H.length);

		System.out.println(res);
		System.out.println("code finished");
	}

}
