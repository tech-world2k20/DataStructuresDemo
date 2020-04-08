package BinaryTree;

public class BTDriverClass2 {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(9);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(13));
		root.getLeft().setLeft(new BinaryTreeNode(3));
		BinaryTreeNode node1 = new BinaryTreeNode(8);
		root.getLeft().setRight(node1);
		root.getRight().setLeft(new BinaryTreeNode(11));
		BinaryTreeNode node2 = new BinaryTreeNode(17);
		root.getRight().setRight(new BinaryTreeNode(15));
		
		root.getRight().getRight().setRight(node2);
		
//		root.printAllAncestorsOfNode(root, node2);
		
		int prev = Integer.MIN_VALUE;
		System.out.println(root.isBST(root, prev));
		
		System.out.println(root.LCA(root, node1, node2).getData());
	}

}
