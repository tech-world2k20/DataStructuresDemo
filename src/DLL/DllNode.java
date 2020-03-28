package DLL;

public class DllNode {
	
	private int data;
	private DllNode next;
	private DllNode previous;
	
	public DllNode(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DllNode getNext() {
		return next;
	}

	public void setNext(DllNode next) {
		this.next = next;
	}

	public DllNode getPrevious() {
		return previous;
	}

	public void setPrevious(DllNode previous) {
		this.previous = previous;
	}

}
