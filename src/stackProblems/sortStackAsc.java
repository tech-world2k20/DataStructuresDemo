package stackProblems;

import java.util.Stack;

public class sortStackAsc {
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int tmp = (int) s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		return r;
	}
	

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(8);
		stack.push(2);
		stack.push(7);
		stack.push(5);
		stack.push(9);
		Stack<Integer> r = sort(stack);
		for (Integer i : r) {
			System.out.println(i);
		}

	}

}
