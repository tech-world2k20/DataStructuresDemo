package Stack;

import java.util.EmptyStackException;

import SLL.SllNode;

public class LinkedListStack {
	
	private SllNode headNode;

	public LinkedListStack() {
		this.headNode = null;
	}
	
	public void push(int data) {
		if(headNode == null) headNode = new SllNode(data);
		else {
			SllNode newNode = new SllNode(data);
			newNode.setNext(headNode);
			headNode = newNode;
		}
	}
	
	public int top() {
		if(headNode == null) return (Integer) null;
		
		else return headNode.getData();
	}
	
	public int pop() {
		if(headNode == null) throw new EmptyStackException();
		else {
			int data  = headNode.getData();
			headNode = headNode.getNext();
			return data;
		}
	}
	
	public boolean isEmpty() {
		return headNode == null;
	}
	
	public void deleteStack() {
		headNode  = null;
	}
	
	public void printStack() {
		SllNode tempNode = headNode;
		while (tempNode != null) {
			System.out.println(tempNode.getData() +" ");
			tempNode = tempNode.getNext();
		}
	}
}
