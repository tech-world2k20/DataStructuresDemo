package Stack;

public class StackDriverClass {
	
	public static void main(String []arg) {
		
//		ArrayStack stack = new ArrayStack(5);
//		stack.push(5);
//		stack.push(6);
//		stack.push(7);
//		stack.push(9);
//		stack.push(3);
//		stack.printStack();
//		System.out.println();
//		System.out.println(stack.pop());
//		System.out.println();
//		stack.printStack();
//		System.out.println();
//		stack.peek();
		
		LinkedListStack stack = new LinkedListStack();
		stack.push(5);
		stack.push(6);
		stack.push(9);
		System.out.println();
		stack.printStack();
		
		
	}

}
