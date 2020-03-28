package DLL;

public class DLListDriverClass {

	public static void main(String[] args) {
		
		DLinkedList list = new DLinkedList();
		list.insertAtFront(9);
		list.insertAtFront(7);
		list.insertAtFront(5);
		list.printDLL();
		
		list.insertAtEnd(11);
		list.printDLL();
		
		int val = 19;
		int pos = 4;
		list.insertNodeAtPos(val , pos);
		list.printDLL();
		list.insertNodeAtPos(23, 6);
		list.printDLL();
		
		list.deleteNodeAtPos(1);
		list.printDLL();
		System.out.println(list.getSize());
		list.deleteNodeAtPos(5);
		list.printDLL();
	}

}
