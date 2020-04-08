package HackerEarth;

import BinaryTree.BinaryTreeNode;

public class tempClass {

	static int cookies(int k, int[] A) {
		int []temparr = A;
		while (true) {
			
		break;	
		}
		return k;
	}

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(9);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(13));
		root.getLeft().setLeft(new BinaryTreeNode(3));
		BinaryTreeNode node1 = new BinaryTreeNode(8);
		root.getLeft().setRight(node1);
		root.getRight().setLeft(new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(19);
		root.getRight().setRight(new BinaryTreeNode(15));

		root.getRight().getRight().setRight(node2);

		tempClass t = new tempClass();
		

		//		9 13 7 3 8 11 15 19 

	}

}
