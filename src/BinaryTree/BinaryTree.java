package BinaryTree;

public class BinaryTree {

	public BinaryTreeNode root;
	public Height height = new Height();
	private int prev= Integer.MIN_VALUE;
	
	public void insert(int data) {
		if(root == null) root = new BinaryTreeNode(data);
		
		root.insert(data);
	}

	public int min() {
		if(root == null) ;

		return root.min();
	}

	public int sizeOfBT() {
		if(root == null) return 0;

		else return root.sizeOfBT(root);

	}

	public void inOrderTraversal() {
		if (root == null) return;
		root.inOrderTraversal();
		System.out.println();
	}
	
	public void kthSmallestElementUsingInOrder(int k) {
		if (root == null) return;
		int c=0;
		root.kthSmallestElementUsingInOrder(root,k, c);
		System.out.println();
	}

	public void preOrderTraversal() {
		if (root == null) return;
		root.preOrderTraversal();
		System.out.println();
	}

	public void postOrderTraversal() {
		if (root == null) return;
		root.postOrderTraversal();
		System.out.println();
	}

	public void levelOrderTraversal() {
		if (root == null) return;
		root.levelOrderTraversal(root);
		System.out.println();
	}

	public void spiralOrderTraversal() {
		if(root == null) return;
		root.spiralOrderTraversal(root);
		System.out.println();
	}
	
	public void spiralWithOneDequeDelimiter() {
		if(root == null) return;
		root.spiralWithOneDequeDelimiter(root);
		System.out.println();
	}
	public int max() {
		if(root == null) ;
		return root.max();
	}

	public boolean checkValueExist(int i) {
		if(root.getData() == i) return true;
		return root.checkValueExist(i);
	}

	public int heightOfBT() {
		if (root == null) ;

		return root.heightOfBT(root);
	}

	public int heightOfBTNonRecursive() {
		if (root == null) ;

		return root.heightOfBTNonRecursive(root);
	}

	public int diameterOfBT() {
		if(root == null) ;
		return root.diameterOfBT(root);
	}
	
	public int diameterOfBTNonRecursive() {
		if(root == null);
		
		return root.diameterOfBTNonRecursive(root, height);
	}

	public int levelWithMaxSum() {
		if(root == null) ;
		
		return root.levelWithMaxSum(root);
	}

	public void convertToMinor() {
		if(root == null) return;
		
		else root.convertToMinor(root);
	}

	public boolean isBST() {
		if(root == null) return true;
		return root.isBST(root, prev);
	}

	public int kthSmallestElement(int k) {
		if(root == null) ;
		
		return root.kthSmallestElement(root, k).getData();
	}

	public void maxSumPath() {
		if(root == null) return;
		
		root.maxSumPath(root);
	}

	public int sumOfAllRightLeaves() {
		if(root == null) return -1;
		root.sumOfAllRightLeaves(root);
		return root.sumOfRightLeaves;
		
	}
	
	
}
