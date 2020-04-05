package stackProblems;

import DLL.DLinkedList;

public class maxSumSlidingWindow {

	public static int method(int[] arr, int w) {
		if(w > arr.length) {
			System.out.println("invalid size"); return -1;
		}
		DLinkedList list = new DLinkedList();
		int maxOf3=0;
		for (int i = 0; i < w; i++) { 
			if(maxOf3 < arr[i]) maxOf3=arr[i];
			list.insertAtEnd(arr[i]);
		}
		for (int i =w ; i < arr.length; i++) {
			int removedValue = list.deleteNodeAtPos(1);
			list.insertAtEnd(arr[i]);
			maxOf3 = (removedValue > arr[i]? (removedValue > maxOf3? removedValue:maxOf3):arr[i]);
		}
		list.printDLL();
		
		return maxOf3;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		System.out.println(method(arr, 2));
	}

}
