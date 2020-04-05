package stackProblems;

import java.util.Stack;

public class QueueUsing2Stack {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public QueueUsing2Stack() {
		s1= new Stack<Integer>();
		s2= new Stack<Integer>();
	}
	
	public void enQueue(int data) {
		s1.push(data);
	}
	
	public int deQueue() {
		if(!s2.isEmpty()) return s2.pop();
		
		else {
			while(!s1.isEmpty()) s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public void printQueue() {
		Stack<Integer> tempStack = (s1.isEmpty()? s2 : s1 );
		while (!tempStack.isEmpty()) {
			System.out.println(tempStack.pop());
		}
	}
	
	public static void main(String[] args) {
		QueueUsing2Stack q = new QueueUsing2Stack();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.printQueue();
	}

}
