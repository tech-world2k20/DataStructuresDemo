package QueueProblems;

import java.util.Stack;

import SLL.SLinkedList;

public class ReverseFirstKItemsInQ {

	public void method(SLinkedList list, int k) {
		int size = list.getSize();
		if(k > size || k<1) return;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			s.push(list.deleteFromFront());
		}
		while (!s.isEmpty()) {
			list.insertNodeAtEnd(s.pop());
		}
		for (int i = 0; i < size-k; i++) {
			list.insertNodeAtEnd(list.deleteFromFront());
		}
		
	}


	public static void main(String[] args) {
		
		SLinkedList list = new SLinkedList();
		ReverseFirstKItemsInQ obj = new ReverseFirstKItemsInQ();
		list.insertNodeAtEnd(1);
		list.insertNodeAtEnd(2);
		list.insertNodeAtEnd(3);
		list.insertNodeAtEnd(4);
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(6);
		list.insertNodeAtEnd(7);
		list.insertNodeAtEnd(8);
		list.insertNodeAtEnd(9);
		obj.method(list,4);
		list.printList();
		
	}

}
