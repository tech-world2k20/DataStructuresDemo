package CLL;

public class CLLNode {


		private int data;
		private CLLNode next;

		public CLLNode(int data) {
			this.data = data;
		}
		
		public CLLNode() {
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public CLLNode getNext() {
			return next;
		}

		public void setNext(CLLNode next) {
			this.next = next;
			
		}
		
		public void printCLL(CLLNode headNode) {
			CLLNode tempNode = headNode;
			while (tempNode != null) {
				System.out.print(tempNode.getData()+" ");
				tempNode = tempNode.getNext();
				if(tempNode == headNode) break;
			}
			System.out.println();
		}
		
		public int size(CLLNode node) {
			int count=0;
			CLLNode headNode = node;
			while (node != null) {
				count++;
				node = node.getNext();
				if(node == headNode)
					break;
			}
			return count;
		}

	}
