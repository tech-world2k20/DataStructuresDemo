package Stack;

public class ArrayStack {
	private int top;
	private int capacity;
	private int[] array;
	
	public ArrayStack(int capacity) {
		top = -1;
		this.capacity= capacity;
		array = new int[capacity];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isStackFull() {
		return top == capacity -1;
	}
	
	public void push(int data) {
		if(isStackFull()) System.out.println("stack full");
		
		else array[++top] = data;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("stack empty");
			return 0;
		}
		else 
			return array[top--];
		
	}
	
	public void deleteStack() {
		top = -1;
	}
	
	public void printStack() {
		for (int i=top; i>=0; i--) {
			System.out.println(array[i]+" ");
		}
	}

	public void peek() {
		if(isEmpty()) System.out.println("Stack empty");
		else System.out.println(array[top]);
		
	}
	
	

}
