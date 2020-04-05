package Queue;

import java.util.EmptyStackException;

public class ArrayQueue {
	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	private ArrayQueue(int size) {
		capacity = size;
		front=-1;
		rear=-1;
		array = new int[size];
	}
	
	public static ArrayQueue createQueue(int size) {
		return new ArrayQueue(size);
	}

	public boolean isEmpty() {
		return front==-1;
	}
	
	public boolean isFull() {
		return (rear+1)%capacity == front;
	}
	
	public int getQueueSize() {
		return (capacity-front+rear+1)%capacity;
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		else {
			rear = (rear+1)%capacity;
			array[rear]= data;
			if(front == -1)
				front = rear;
		}
	}
	
	public int deQueue() {
		if(isEmpty()) throw new EmptyStackException();
		
		int data = array[front];
		if(front==rear)
			front=rear-1;
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
		ArrayQueue queue = new ArrayQueue(5);
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
		queue.enQueue(56);
		queue.enQueue(77);
		queue.enQueue(90);
		
		queue.printQueue();
	}
}
