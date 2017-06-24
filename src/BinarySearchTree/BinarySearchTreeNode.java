package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class BinarySearchTreeNode {

	int data;
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	
	BinarySearchTreeNode(int data, BinarySearchTreeNode left, BinarySearchTreeNode right) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.left=left;
		this.right=right;
	}

	
	
	
	public static BinarySearchTreeNode searchBST(BinarySearchTreeNode root, int key) {
									 //searchBST(50,60)	
									      //searchBST(70,60)
												//searchBST(60,60)
		
		if (root == null) { // 1   
			return null;
		}

		else if (root.data == key) { // 2
			return root;
		}

		else {
			if (key < root.data) { // 3
				BinarySearchTreeNode search = searchBST(root.left, key);
				 							 //search = searchBST(60,60) = 60
				return search;
			} else { // 4
				
				BinarySearchTreeNode search = searchBST(root.right, key); 
				  							//search = searchBST(70,60) = 60;
				return search;
			
			}
		}

	}
	
	public static BinarySearchTreeNode createRandomBinarySearchTree(){
		BinarySearchTreeNode left4 = new BinarySearchTreeNode(5, null, null);
		
		BinarySearchTreeNode left3 = new BinarySearchTreeNode(60, null, null);
		BinarySearchTreeNode right3 = new BinarySearchTreeNode(80, null, null);
		
		BinarySearchTreeNode left2 = new BinarySearchTreeNode(10, left4, null);
		BinarySearchTreeNode right2 = new BinarySearchTreeNode(30, null, null);		
		
		BinarySearchTreeNode left1 = new BinarySearchTreeNode(20, left2, right2);
		BinarySearchTreeNode right1 = new BinarySearchTreeNode(70, left3, right3);
		
		BinarySearchTreeNode root = new BinarySearchTreeNode(50, left1, right1);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTreeNode root = createRandomBinarySearchTree();
		//System.out.println(root.left.data);
		BinarySearchTreeNode search = searchBST(root,60); //search = searchBST(50,60) = 60
		System.out.println(search.data); //60
		
	}
	
	

}
