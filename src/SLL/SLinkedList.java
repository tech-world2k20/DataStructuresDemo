package SLL;

public class SLinkedList {

	private SllNode headNode;
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
	
	public int getSize() {
		int len=0;
		SllNode currNode = headNode;
		while (currNode != null) {
			len++;
			currNode = currNode.getNext();
		}
		return len;
	}

	public void printList() {
		SllNode tempNode = headNode;
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
		if(headNode == null) headNode = newNode;

		else 
			traverseTillEnd(headNode).setNext(newNode);
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
		tempNode.setNext(headNode);
		headNode = tempNode;	
	}

	public void insertAtPost(int data, int pos) {

	}

	public int deleteFromFront() {
		if(headNode == null) ;
		SllNode tempNode = headNode;
		headNode = tempNode.getNext();
		size--;
		
		return tempNode.getData();
	}

	public void deleteFromEnd() {
		if(isEmpty())
			try {
				throw new Exception("emppty list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		if(size == 1) { 
			headNode = null;
			return;
		}
		SllNode prevToLastNode = null;
		SllNode lastNode = headNode;
		while(lastNode.getNext() != null) {
			prevToLastNode = lastNode;
			lastNode = lastNode.getNext();
		}
		prevToLastNode.setNext(null);
		size--;
	}
	
	public void createLoop() {
		SllNode tempNode = headNode;
		int count=4;
		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
		}
		SllNode lastNode  = tempNode;
		tempNode = headNode;
		while (count > 1) {
			tempNode = tempNode.getNext();
			count--;
		}
		lastNode.setNext(tempNode);
	}
	

	public Boolean isEmpty() {
		return headNode == null;
	}

	public boolean checkLoopExist() {
		if(headNode == null) return false;
        boolean result=false;
        SllNode sPtr=headNode;
        SllNode fPtr=headNode;
        while(fPtr != null && fPtr.getNext() != null){
            sPtr = sPtr.getNext();
            fPtr = fPtr.getNext().getNext();
            if(sPtr == fPtr){
                result = true;
                break;
            }
        }
        return result;
		
	}

	public int findLoopNode() {
        SllNode sPtr=headNode;
        SllNode fPtr=headNode;
        while(fPtr != null && fPtr.getNext() != null){
            sPtr = sPtr.getNext();
            fPtr = fPtr.getNext().getNext();
            if(sPtr == fPtr) break;            
        }
        fPtr = headNode;
        while (sPtr != fPtr) {
			sPtr = sPtr.getNext();
			fPtr = fPtr.getNext();
		}
        return sPtr.getData();
		
	}
}
