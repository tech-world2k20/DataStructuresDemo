package stackProblems;

import java.util.Stack;

public class findingSpansV2 {

	public int[] method(int[] intpArr) {
		int[] spans = new int[intpArr.length];
		Stack<Integer> stack = new Stack<Integer>();
		int p=0;
		for (int i = 0; i < spans.length; i++) {

			while (!stack.isEmpty() && intpArr[i] > intpArr[stack.peek()])
				stack.pop();

				if (stack.isEmpty()) p=-1;
				
				else p=stack.peek();
				
				spans[i] = i-p;
				stack.push(i);
			
		}

		return spans;
	}


	public static void main(String[] argStrings) {

		findingSpansV2 s = new findingSpansV2();
		int[] res =s.method(new int[] {6,3,4,5,2});
		for (int i : res) {
			System.out.print(i +" ");
		}
	}

}
