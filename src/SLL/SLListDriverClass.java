package SLL;

public class SLListDriverClass {
	
	public static void main(String args[]) {
		
		SLinkedList list = new SLinkedList();
		
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(7);
		list.insertNodeAtEnd(9);
		list.deleteFromEnd();
		list.printList();
		list.insertNodeAtFront(3);
		System.out.println(list.size);
		list.printList();
		
		list.deleteFromFront();
		list.printList();
		System.out.println(list.size);
		
		list.deleteFromEnd();
		System.out.println(list.size);
		list.printList();
		
		list.deleteFromEnd();
		System.out.println(list.size);
		list.printList();
		
		list.deleteFromEnd();
		System.out.println(list.size);
		list.printList();
		
		
	}
	
}
