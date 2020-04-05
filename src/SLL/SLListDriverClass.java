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
		list.insertNodeAtFront(2);
		list.insertNodeAtEnd(13);
		list.insertNodeAtEnd(15);
		list.insertNodeAtEnd(19);
		list.printList(); //Head -> 2 -> 3 -> 5 -> 7 -> 13 -> 15 -> 19 -> Null
		list.createLoop();
		System.out.println(list.checkLoopExist());
		System.out.println(list.findLoopNode());
//		list.printList();
		
	}
	
}
