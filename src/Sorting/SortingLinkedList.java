package Sorting;

import SLL.SllNode;

public class SortingLinkedList {
	
	public static int getLength(SllNode head) {
		if(head == null) return 0;
		int len =0;
		while(head != null) {
			len++;
			head = head.getNext();
		}
		return len;
	}
	
	public static SllNode getMiddle(SllNode head) {
		if(head == null)
			return head;
		SllNode slow=head, fast = head;
		while (fast.getNext()!=null && fast.getNext().getNext()!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
	public static SllNode mergeSort(SllNode head) {
		if(head == null || head.getNext() == null)
				return head;
		
		SllNode mid = getMiddle(head);
		SllNode nextToMid = mid.getNext();
		mid.setNext(null);
		
		SllNode left = mergeSort(head);
		SllNode right = mergeSort(nextToMid);
		
		SllNode newHead = sortedMerge(left, right);
		
		return newHead;
	}

	private static SllNode sortedMerge(SllNode left, SllNode right) {
		if(left == null)
				return right;
		if(right == null)
				return left;
		SllNode result = null;
		
		if(left.getData() < right.getData()) {
			result = left;
			result.setNext(sortedMerge(left.getNext(), right));
		}
		else {
			result = right;
			result.setNext(sortedMerge(left, right.getNext()));
		}

/*		
		SllNode temp = new SllNode(0);
		result = temp;
		
		while(left != null && right != null) {
			if(left.getData() < right.getData()) {
				result = left;
				result = result.getNext();
				left = left.getNext();
			}
			else {
				result = right;
				result = result.getNext();
				right = right.getNext();
			}
		}
		if(left == null && right != null)
			result.setNext(right);
		
		else if(right == null && left !=null)
			result.setNext(left);
*/		
		
		return result;
	}

	public static void printList(SllNode head) {
		System.out.print("Head -> ");
		while(head != null) {
			System.out.print(head.getData()+" -> ");
			head = head.getNext();
		}
		System.out.println("Null");
	}
	
	public static void main(String[] args) {
		SllNode headNode = new SllNode(9);
		headNode.setNext(new SllNode(-45));
		headNode.getNext().setNext(new SllNode(25));
		headNode.getNext().getNext().setNext(new SllNode(11));
		headNode.getNext().getNext().getNext().setNext(new SllNode(19));
		headNode.getNext().getNext().getNext().getNext().setNext(new SllNode(37));
		headNode.getNext().getNext().getNext().getNext().getNext().setNext(new SllNode(1));
		headNode.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new SllNode(999));
		headNode.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new SllNode(8));
		printList(headNode);
		
		SllNode returnedList = mergeSort(headNode);
		printList(returnedList);
		
	}
	
}
