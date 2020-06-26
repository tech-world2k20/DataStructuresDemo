package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Height {
	int h;
}
public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	public int getData() {
		return data;
	}

	public BinaryTreeNode(int data) {
		super();
		this.data = data;
	}

	public void insert(int value) {
		if(data == value) return;

		else if (value < data) {
			if(left == null) left = new BinaryTreeNode(value);

			left.insert(value);
		}else {
			if(right == null) right = new BinaryTreeNode(value);

			right.insert(value);
		}
	}

	public int min() {
		if(left == null) return data;

		return left.min();
	}

	public int max() {
		if(right == null) return data;

		return right.max();
	}

	public boolean checkValueExist(int i) {
		if(i == data) return true;
		
		else if (i < data) {
			if(left != null) return left.checkValueExist(i);
			
			else return false;
		}else {
			if(i > data) {
				if(right != null) return right.checkValueExist(i);
				
				else return false;
			}
		}
		return false;
	}
	
	public boolean isBST(BinaryTreeNode root, int prev) {
		if(root ==null) return true;
		
		if(!isBST(root.left , prev))  return false;
		
		if(root.data < prev) return false;
		
		prev = root.data;;
		return isBST(root.right, prev);
	}
	
	public void inOrderTraversal() {
		if(left != null) left.inOrderTraversal();

		System.out.print(data+" ");
		if(right != null) right.inOrderTraversal();
	}

	public void preOrderTraversal() {
		System.out.print(data+" ");

		if(left != null) left.inOrderTraversal();

		if(right != null) right.inOrderTraversal();
	}

	public void postOrderTraversal() {
		if(left != null) left.inOrderTraversal();

		if(right != null) right.inOrderTraversal();
		System.out.print(data+" ");
	}

	public void levelOrderTraversal(BinaryTreeNode root) {
		BinaryTreeNode tempNode;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			tempNode = q.poll();
			if(tempNode.left != null) q.add(tempNode.left);
			if (tempNode.right != null) q.add(tempNode.right);
			System.out.print(tempNode.data +" ");
		}
		System.out.println();
	}
	
	public void spiralOrderTraversal(BinaryTreeNode root) {
		if(root == null) return;
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		BinaryTreeNode tempNode;
		s1.add(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				tempNode = s1.pop();
				if(tempNode.left != null) s2.add(tempNode.left);
				if(tempNode.right != null) s2.add(tempNode.right);
				System.out.print(tempNode.data+" ");
			}
			
			while (!s2.isEmpty()) {
				tempNode = s2.pop();
				if(tempNode.right != null) s1.add(tempNode.right);
				if(tempNode.left != null) s1.add(tempNode.left);
				System.out.print(tempNode.data+" ");
			}
		}
	} 
	
	public void spiralWithOneDequeDelimiter(BinaryTreeNode root) {
        if(root == null){
            return;
        }
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offerFirst(root);
        //if only delimiter(in this case null) is left in queue then break
        while(q.size() > 1){
            root = q.peekFirst();
            while(root != null){
                root = q.pollFirst();
                System.out.print(root.getData() + " ");
                if(root.getLeft() != null) q.offerLast(root.getLeft());
                if(root.getRight() != null) q.offerLast(root.getRight());
                root = q.peekFirst();
            }
            root = q.peekLast();
            while(root != null){
                System.out.print(root.getData() + " ");
                root = q.pollLast();
                if(root.getRight() != null) q.offerFirst(root.getRight()); 
                if(root.getLeft() != null)  q.offerFirst(root.getLeft());
                root = q.peekLast();
            }
        }
    }
	
	public int levelWithMaxSum(BinaryTreeNode root) {
		BinaryTreeNode tempNode;
		int currSum=0, maxSum=0;
		int level=1, maxLevel=0;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			tempNode = q.poll();
			if(tempNode == null) {
				if(currSum > maxSum) {
					maxSum = currSum;
					maxLevel = level;
				}
				currSum =0;
				if(!q.isEmpty())
					q.add(null);
				
				level++;
			}else {
				currSum += tempNode.getData();
				if(tempNode.left != null) q.add(tempNode.left);
				if(tempNode.right != null) q.add(tempNode.right);
			}
			
		}
		
		return maxLevel;
	}

	public int sizeOfBT(BinaryTreeNode root) {
		if(root == null) return 0;
		return (sizeOfBT(root.left)+1+sizeOfBT(root.right));
	}
	
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public int heightOfBT(BinaryTreeNode root) {
		if(root == null) return 0;
		
		return Math.max(heightOfBT(root.left),heightOfBT(root.right))+1;
	}

	public int heightOfBTNonRecursive(BinaryTreeNode root) {
		int level =0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if(root == null) return 0;
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if(root == null) {
				if(!q.isEmpty()) 
					q.add(null);
				level++;
			}else {
				if(root.left !=null) q.add(root.left);
				if(root.right !=null) q.add(root.right);
			}
		}
		return level;
	}

	public int diameterOfBT(BinaryTreeNode root) {
		if(root == null) return 0;
		
		int lheight = heightOfBT(root.left);
		int rheight = heightOfBT(root.right);
		
		int ldiameter = diameterOfBT(root.left);
		int rdiameter = diameterOfBT(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
	}

	public int diameterOfBTNonRecursive(BinaryTreeNode root, Height height) {
		
		if(root == null) {
			height.h = 0;
			return 0;
		}
		Height lh = new Height(), rh = new Height();
		
		int ldiameter = diameterOfBTNonRecursive(root.left, lh);
		int rdiameter = diameterOfBTNonRecursive(root.right, rh);
		
		height.h = Math.max(lh.h, rh.h) +1;
		return Math.max(lh.h+rh.h+1, Math.max(ldiameter, rdiameter));
	}

	public BinaryTreeNode convertToMinor(BinaryTreeNode root) {
		BinaryTreeNode tempNode;
		if(root != null) {
			convertToMinor(root.left);
			convertToMinor(root.right);
			tempNode = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(tempNode);	
		}
		
		return root;
	}
	
	public boolean printAllAncestorsOfNode(BinaryTreeNode root , BinaryTreeNode node) {
		if(root == null) return false;
		
		if(root.left == node || root.right == node || printAllAncestorsOfNode(root.left, node) || printAllAncestorsOfNode(root.right, node)) {
			System.out.println(root.data+" " );
			return true;
		}
		return false;
	}

	public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		BinaryTreeNode left,right;
		if(root == null) return root;
		if(root == node1 || root == node2) return root;
		left = LCA(root.left, node1, node2);
		right = LCA(root.right, node1, node2);
		if(left!=null && right!=null) return root;
		
		else return (left!=null? left:right);
	}
	
	private int count=0;
	public BinaryTreeNode kthSmallestElement(BinaryTreeNode root, int k) {
		if(root == null) return null;
		
		BinaryTreeNode leftnNode = kthSmallestElement(root.left, k);
		
		if(leftnNode != null) return leftnNode;
		
		if(++count == k) return root;
		
		return kthSmallestElement(root.right, k);
	}
	
	
	public void kthSmallestElementUsingInOrder(BinaryTreeNode root, int k, int c) {
		if(root.left != null) kthSmallestElementUsingInOrder(root.left, k ,c);

		if(++c == k) { 
			System.out.println(data );
			return;
		}
		if(root.right != null) kthSmallestElementUsingInOrder(root.right, k,c);
	}
	
//	int max_sum=0;
	public void maxSumPath(BinaryTreeNode root) {
		if(root == null) return ;
		
	}
	
	int sumOfRightLeaves=0;
	public void sumOfAllRightLeaves(BinaryTreeNode root) {
		if(root == null) return;

		if(root.right != null) {
		if(root.right.left == null && root.right.right == null)
			sumOfRightLeaves += root.right.data;
		}

		sumOfAllRightLeaves(root.left);
		sumOfAllRightLeaves(root.right);
	}
	
}
