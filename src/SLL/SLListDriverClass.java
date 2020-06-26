package SLL;

public class SLListDriverClass {
	
	public static void main(String args[]) {
		
		SLinkedList list = new SLinkedList();
		
		list.insertNodeAtEnd(5);
		list.insertNodeAtEnd(87);
		list.insertNodeAtEnd(92);
		list.deleteFromEnd();
		list.printList();
		list.insertNodeAtFront(53);
		System.out.println(list.size);
		list.printList();
		
//		list.deleteFromFront();
//		list.printList();
//		System.out.println(list.size);
//		
//		list.deleteFromEnd();
//		System.out.println(list.size);
//		list.printList();
//		
//		list.deleteFromEnd();
//		System.out.println(list.size);
//		list.printList();
//		
//		list.deleteFromEnd();
//		System.out.println(list.size);
//		list.printList();
		list.insertNodeAtFront(02);
		list.insertNodeAtEnd(113);
		list.insertNodeAtEnd(9);
		list.insertNodeAtEnd(19);
		list.printList(); //Head -> 2 -> 3 -> 5 -> 7 -> 13 -> 15 -> 19 -> Null
		list.createLoop();
		System.out.println(list.checkLoopExist());
		System.out.println(list.findLoopNode());
//		list.printList();
		
	}
	
}
