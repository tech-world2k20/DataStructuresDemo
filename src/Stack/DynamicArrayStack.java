package Stack;

public class DynamicArrayStack {
	private int top;
	private int capacity;
	private int[] array;
	
	public DynamicArrayStack() {
		top = -1;
		capacity = 1;
		array = new int[capacity];
	}
	
	public void doubleStack() {
		int[] tempArray = new int[2*capacity];
		System.arraycopy(array, 0, tempArray, 0, capacity);
		capacity = 2*capacity;
		array = tempArray;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isStackFull() {
		return top == capacity -1;
	}
	
	public void push(int data) {
		if(isStackFull()) doubleStack();
		
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
