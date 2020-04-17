package Heap;

public class HeapClass {
	
	private int[] heap;
	private int size;
	
	public HeapClass(int capacity) {
		heap = new int[capacity];
	}

	public boolean isFull() {
		return size == heap.length;
	}
	
	public int getParent(int index) {
		if(index > this.size || index < 0) return -1;
		return (index-1)/2;
	}
	
	public int getLeftChild(int i) {
		if(i>=this.size) return -1;
		return 2*i+1;
	}
	
	public int getRightChild(int i) {
		if(i>=this.size) return -1;
		return 2*i +2;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public void insert(int val) {
		if(isFull()) throw new IndexOutOfBoundsException();
		
		heap[size] = val;
		fixHeapAbove(size);
		size++;
	}
	
	public void fixHeapAbove(int index) {
		int newVal = heap[index];
		while (index > 0 && newVal > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)]; 
			index = getParent(index);
		}
		heap[index] = newVal; 
	}
	
	private void fixHeapBelow(int index, int lastHeapIndex) {
		int childToSwap = 0;
		while (index <= lastHeapIndex) {
			int leftChild = getLeftChild(index);
			int rightChild = getRightChild(index);
			if(leftChild <= lastHeapIndex) {
				if(rightChild > lastHeapIndex) 
					childToSwap = leftChild;
				else 
					childToSwap = (heap[leftChild] > heap[rightChild]? leftChild:rightChild);
		
			if(heap[index] < heap[childToSwap]) {
				int tmp = heap[index];
				heap[index ] = heap[childToSwap];
				heap[childToSwap] =tmp;
			}
			else break;
				
			index = childToSwap;
			} 
			else break;
		}
	}
	
	public int deleteNode(int index) {
		if(isEmpty()) throw new IndexOutOfBoundsException();
		int parentIndex = getParent(index);
		int deletedValue = heap[index];
		heap[index] = heap[size-1];
		
		if(index == 0 || heap[index] < heap[parentIndex])
			fixHeapBelow(index, size-1);
		else 
			fixHeapAbove(index);
		
		size--;
		
		return deletedValue;
	}
	
	public void printHeap() {
		for (int i=0; i<size; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
	
	public int peek() {
		if(isEmpty()) throw new IndexOutOfBoundsException("heap is empty");
		return heap[0];
	}

	public void sort() {
		if(isEmpty()) throw new IndexOutOfBoundsException("heap is empty");
		int lastIndexIndex= size-1;
		
		for(int i=0; i< lastIndexIndex ; i++) {
			swqp(0, lastIndexIndex-i);
			
			fixHeapBelow(0, lastIndexIndex-i-1);
		}
		
	}

	public void swqp(int a,int b) {
		int c = heap[a];
		heap[a]=heap[b];
		heap[b]=c;
	}
}
