package BinaryTree;

public class BTreeDriverClass {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();

		tree1.insert(9);
		tree1.insert(7);
		tree1.insert(3);
		tree1.insert(13);
		tree1.insert(11);
		tree1.insert(15);
		tree1.insert(8);
		tree1.insert(17);

		tree1.inOrderTraversal();
//		tree1.preOrderTraversal();
//		tree1.postOrderTraversal();
		tree1.levelOrderTraversal();
		
		tree1.spiralOrderTraversal();
		
		tree1.spiralWithOneDequeDelimiter();
		System.out.println("Is BST :" + tree1.isBST());
//		System.out.println(tree1.min());
//		System.out.println(tree1.max());
//		System.out.println(tree1.checkValueExist(13));

//		System.out.println(tree1.sizeOfBT());
//
//		System.out.println("heightOfBT :"+ tree1.heightOfBT());
//
//		System.out.println("heightOfBTNonRecursive :"+tree1.heightOfBTNonRecursive());
//
//		System.out.println("diameterOfBT :"+tree1.diameterOfBT());
//
//		System.out.println("diameterOfBTNonRecursive :"+tree1.diameterOfBTNonRecursive());
//
//		System.out.println("levelWithMaxSum :"+tree1.levelWithMaxSum());
		
//		tree1.convertToMinor();
		
		System.out.println("kthSmallestElement :"+ tree1.kthSmallestElement(4));
		
		System.out.print("kthSmallestElementUsingInOrder :");tree1.kthSmallestElementUsingInOrder(4);
		
//		tree1.maxSumPath();
		
		System.out.println(tree1.sumOfAllRightLeaves());
		
	}

}
