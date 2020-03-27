package SLL;

import java.util.EmptyStackException;

public class SLinkedList {

	private SllNode sllHeadNode;
	int size;

	public int getSize(SllNode head) {
		int len=0;
		SllNode currNode = head;
		while (currNode != null) {
			len++;
			currNode = currNode.getNext();
		}
		return len;
	}

	public void printList() {
		SllNode tempNode = sllHeadNode;
		System.out.print("Head -> ");
		while (tempNode != null) {
			System.out.print(tempNode.getData()+" -> ");
			tempNode = tempNode.getNext();
		}
		System.out.println("Null");
	}

	public void insertNodeAtEnd(int data) {
		size++;
		SllNode newNode = new SllNode(data);
		if(sllHeadNode == null) sllHeadNode = newNode;

		else 
			traverseTillEnd(sllHeadNode).setNext(newNode);
	}

	private SllNode traverseTillEnd(SllNode node) {
		SllNode currNode = node;
		while (currNode != null && currNode.getNext() != null) {
			currNode = currNode.getNext();
		}
		return currNode;
	}

	public void insertNodeAtFront(int i) {
		size++;
		SllNode tempNode = new SllNode(i);
		tempNode.setNext(sllHeadNode);
		sllHeadNode = tempNode;	
	}

	public void insertAtPost(int data, int pos) {

	}

	public void deleteFromFront() {
		if(sllHeadNode == null) return;
		SllNode tempNode = sllHeadNode;
		sllHeadNode = tempNode.getNext();
		tempNode = null;
		size--;
	}

	public void deleteFromEnd() {
		if(isEmpty())
			try {
				throw new Exception("emppty list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		if(size == 1) { 
			sllHeadNode = null;
			return;
		}
		SllNode prevToLastNode = null;
		SllNode lastNode = sllHeadNode;
		while(lastNode.getNext() != null) {
			prevToLastNode = lastNode;
			lastNode = lastNode.getNext();
		}
		prevToLastNode.setNext(null);
		size--;
	}
	

	public Boolean isEmpty() {
		return sllHeadNode == null;
	}
}
