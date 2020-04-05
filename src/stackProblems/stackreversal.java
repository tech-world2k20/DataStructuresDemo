package stackProblems;

import java.util.Stack;

public class stackreversal {
	public static void reverseStack(Stack< Integer> stack) {
		if(stack.isEmpty()) return;
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
		
	}

	public static void main(String []args) {
		Stack< Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(7);
		stack.push(5);
		stack.push(3);
		reverseStack(stack);
		
	}

}
