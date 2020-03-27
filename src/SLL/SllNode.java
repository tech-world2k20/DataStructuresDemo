package SLL;

public class SllNode {

	private int data;
	private SllNode next;

	public SllNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SllNode getNext() {
		return next;
	}

	public void setNext(SllNode next) {
		this.next = next;
	}

}
