package stackProblems;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	
	public StackUsing2Queue() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int data) {
		if(q1.isEmpty())
			q2.add(data);
		
		else q1.add(data);
	}
	
	public int pop() {
		int s = q2.size();
		if(q1.isEmpty()) {
			for (int i = 0; i < s-1; i++) {
				q1.add(q2.poll());
			}
			return q2.poll();
		}else {
			s= q1.size();
			for (int i = 0; i < s-1; i++) {
				q2.add(q1.poll());
			}
			return q1.poll();
		}
	}
	public void printStack() {
		Queue<Integer> tempQueue;
		if(q1.isEmpty()) {
			int i= q2.size();
			tempQueue = q2;
			while(!q2.isEmpty()){
				System.out.println(tempQueue.poll());
			}
		}else {
			int i= q1.size();
			tempQueue = q1;
			while(!q1.isEmpty()){
				System.out.println(tempQueue.poll());
			}
		}
	}


	public static void main(String[] args) {
		StackUsing2Queue s = new StackUsing2Queue();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.printStack();
	}

}
