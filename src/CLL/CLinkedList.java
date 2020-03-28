package CLL;

public class CLinkedList {

	private CLLNode headNode;
	private int size;

	public void insertAtFront(int data) {
		CLLNode newNode = new CLLNode(data);
		newNode.setNext(newNode);
		if(headNode == null) headNode = newNode;
		else {
			CLLNode tempNode = headNode;
			while (tempNode.getNext() != headNode) {
				tempNode = tempNode.getNext();
			}
			newNode.setNext(headNode);
			tempNode.setNext(newNode);
			headNode = newNode;

		}
	}

	public void insertAtEnd(int data) {
		CLLNode newNode = new CLLNode(data);
		newNode.setNext(newNode);
		if(headNode == null) headNode = newNode;
		else {
			CLLNode tempNode = headNode;
			while (tempNode.getNext() != headNode) {
				tempNode = tempNode.getNext();
			}
			newNode.setNext(headNode);
			tempNode.setNext(newNode);
		}
	}
	public void deleteFromEnd() {
		if(isEmpty()) return;
		CLLNode prevToLastNode = null;
		CLLNode lastNode= headNode;
		while (lastNode.getNext() != headNode) {
			prevToLastNode = lastNode;
			lastNode = lastNode.getNext();
		}
		prevToLastNode.setNext(lastNode.getNext());
		lastNode=null;
	}

	public void deleteFromFront() {
		if(isEmpty()) return;
		CLLNode NodeToBeDeleted = headNode;
		CLLNode lastNode= headNode;
		while (lastNode.getNext() != headNode) {
			lastNode = lastNode.getNext();
		}
		lastNode.setNext(headNode.getNext());
		headNode = headNode.getNext();
		NodeToBeDeleted.setNext(null);
		
	}
	public int CLLlength() {
		int len =0;
		CLLNode tempNode = headNode;
		while (tempNode != null) {
			len++;
			tempNode = tempNode.getNext();
			if(tempNode == null) break;
		}
		return len;
	}

	public void printCLL() {
		CLLNode tempNode = headNode;
		while (tempNode != null) {
			System.out.print(tempNode.getData()+" ");
			tempNode = tempNode.getNext();
			if(tempNode == headNode) break;
		}
		System.out.println();
	}
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return headNode == null;
	}
	
}