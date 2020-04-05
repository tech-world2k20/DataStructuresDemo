package DLL;

public class DLinkedList {
	
	private DllNode headNode;
	private int size;
	
	public void insertAtFront(int data) {
		DllNode tempNode = new DllNode(data);
		size++;
		if (isEmpty()) {
			headNode = tempNode;
			return;
		}
		tempNode.setNext(headNode);
		headNode.setPrevious(tempNode);
		headNode = tempNode;
	}
	
	public void insertAtEnd(int i) {
		size++;
		DllNode tempNode = new DllNode(i);
		if(headNode == null)
			headNode = tempNode;
		else {

			DllNode curNode = headNode;
			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			curNode.setNext(tempNode);
			tempNode.setPrevious(curNode);
		}
	}
	
	public boolean isEmpty() {
		return headNode == null;
	}
	
	public void printDLL() {
		if(isEmpty()) return;
		DllNode tempNode = headNode;
		System.out.print("HEAD => ");
		while (tempNode != null) {
			System.out.print(tempNode.getData() +" => ");
			tempNode = tempNode.getNext();
		}
		System.out.println("NULL");
	}

	public void insertNodeAtPos(int val, int pos) {
		
		if(pos > size+1 || pos < 0) return;
		size++;
		if(pos == 1) {
			insertAtFront(val);
			return;
		}
		int count =1;
		DllNode prevNode = headNode;
		DllNode tempNode = new DllNode(val);
		while (count < pos-1) {
			prevNode = prevNode.getNext();
			count++;
		}
		DllNode curNode = prevNode.getNext();
		tempNode.setNext(curNode);
		if(curNode != null) curNode.setPrevious(tempNode);
		prevNode.setNext(tempNode);
		tempNode.setPrevious(prevNode);

	}

	public int deleteNodeAtPos(int pos) {
		if(pos > size || pos < 0) {};
		size--;
		int removedVal;
		if(pos == 1) {
			removedVal = headNode.getData();
			headNode = headNode.getNext();
			headNode.setPrevious(null);
		}
		else {
			DllNode prevNode = headNode;
			int count = 1;
			while (count< pos-1) {
				prevNode = prevNode.getNext();
				count++;
			}
			DllNode currNode = prevNode.getNext();
			DllNode laterNode = currNode.getNext();
			prevNode.setNext(laterNode);
			if(laterNode != null) laterNode.setPrevious(prevNode);
			removedVal = currNode.getData();
		}
		return removedVal;
		
	}

	public int getSize() {
		return size;
	}


}
