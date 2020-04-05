package stackProblems;

import Stack.LinkedListStack;
public class minStack  {
	
	private LinkedListStack stack = new LinkedListStack();
	public LinkedListStack minStack = new LinkedListStack();
	
	public void push(int data) {
		stack.push(data);
		if(minStack.isEmpty() || minStack.top() >= data) 
			minStack.push(data);
		else 
			minStack.push(minStack.top());
	}
	
	public Integer pop() {
		if(stack.isEmpty()) return null;
		minStack.pop();
		return stack.pop();
	}
	
	public int getMin() {
		return minStack.top();
	}
	
	public int top() {
		return stack.top();
	}
	public void printStrack() {
		stack.printStack();
	}
	
	public static void main(String []args) {
		minStack ss = new minStack();
		ss.push(2);
		ss.push(6);
		ss.push(4);
		ss.push(1);
		ss.push(5);
		ss.printStrack();
		System.out.println();
		System.out.println(ss.getMin());
		ss.pop();
		ss.pop();
		System.out.println();
		System.out.println(ss.getMin());
//		ss.pop();
//		System.out.println();
	}
}
