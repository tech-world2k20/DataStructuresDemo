package Queue;

import java.util.EmptyStackException;

public class DynamicArrayQueue {
	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	public DynamicArrayQueue() {
		capacity = 1;
		front=-1;
		rear=-1;
		array = new int[1];
	}
	
	public static DynamicArrayQueue createQueue() {
		return new DynamicArrayQueue();
	}

	public boolean isEmpty() {
		return front==-1;
	}
	
	public boolean isFull() {
		return (rear+1)%capacity == front;
	}
	
	public int getQueueSize() {
		if(front == -1) return 0;
		int size =(capacity-front+rear+1)%capacity;
		if(size == 0) return capacity;
		else return size;
	}
	
	public void enQueue(int data) {
		if(isFull()) 
			resizeQueue();
			rear = (rear+1)%capacity;
			array[rear]= data;
			if(front == -1)
				front = rear;
		
	}
	
	private void resizeQueue() {
		int initCap = capacity;
		capacity *=2;
		int[] oldArray = array;
		array = new int[this.capacity];
		for (int i = 0; i < oldArray.length; i++) {
			array[i] = oldArray[i];
		}
		if(rear<front) {
			for (int i = 0; i < front; i++) {
				array[i+initCap] = this.array[i];
			}
			rear = rear+initCap;
		}
		
	}

	public int deQueue() {
		if(isEmpty()) throw new EmptyStackException();
		
		int data = array[front];
		if(front==rear)
			front=rear=-1;
		else front=(front+1)%capacity;
		
		return data;
	}
	
	public void printQueue() {
		if(isEmpty()) return;
		
		if(front < rear) {
			for (int i = front; i <= rear; i++)
				System.out.println(array[i]);
		}else {
			for (int i = front; i < array.length; i++)
				System.out.println(array[i]);
			
			for (int i = 0; i <= rear; i++)
				System.out.println(array[i]);
		}
	}
	
	public static void main(String[] agrs) {
		DynamicArrayQueue queue = new DynamicArrayQueue();
		queue.enQueue(5);
		queue.enQueue(8);
		queue.enQueue(3);
		queue.deQueue();
		queue.enQueue(1);
		queue.deQueue();
		queue.enQueue(7);
		queue.deQueue();
		queue.enQueue(9);
		queue.deQueue();
		queue.enQueue(72);
		queue.deQueue();
		queue.enQueue(27);
		queue.deQueue();
		queue.enQueue(29);
		queue.deQueue();
		queue.enQueue(6);
//		queue.enQueue(77);
//		queue.enQueue(90);
//		queue.enQueue(73);
//		queue.enQueue(119);
		System.out.println(queue.capacity);
		System.out.println();
		
//		queue.enQueue(99);
		System.out.println(queue.capacity);
		queue.printQueue();
	}
}
