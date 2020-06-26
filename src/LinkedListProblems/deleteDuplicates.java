package LinkedListProblems;

import SLL.SllNode;

public class deleteDuplicates {
	
	
	static SllNode removeDuplicates(SllNode head) {
		 if(head == null || head.getNext() == null) return head;
	        SllNode current =head;
	        
	        while(current.getNext() != null){
	        	
	            if(current.getData() == current.getNext().getData())
	                current.setNext(current.getNext().getNext());
	            
	            else  current = current.getNext();
	        }
	        return head;
   }
	
	public static void main(String args[]) {
		SllNode heaNode = new SllNode(5);
		SllNode node2 = new SllNode(2);
		SllNode node3 = new SllNode(2);
		SllNode node3a = new SllNode(2);
		SllNode node3b = new SllNode(2);
		SllNode node4 = new SllNode(4);
		SllNode node5 = new SllNode(7);
		heaNode.setNext(node2);
		heaNode.getNext().setNext(node3);
		heaNode.getNext().getNext().setNext(node3a);
		heaNode.getNext().getNext().getNext().setNext(node3b);
		heaNode.getNext().getNext().getNext().getNext().setNext(node3b);
		heaNode.getNext().getNext().getNext().getNext().getNext().setNext(node4);
		SllNode res =removeDuplicates(heaNode);
		while (res != null) {
			System.out.print(res.getData()+" ");
			res  = res.getNext();
		}
		
	}

}
