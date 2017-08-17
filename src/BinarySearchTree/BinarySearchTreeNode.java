package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.BinaryTreeNode;

public class BinarySearchTreeNode {

	int data;
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	BinarySearchTreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	BinarySearchTreeNode(int data, BinarySearchTreeNode left, BinarySearchTreeNode right) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.left=left;
		this.right=right;
	}

	
	public static BinarySearchTreeNode searchBST(BinarySearchTreeNode root, int key) {
		
		if (root == null) { 
			return null;
		}
		else if (root.data == key) { 
			return root;
		}

		else {
			if (key < root.data) { 
				BinarySearchTreeNode search = searchBST(root.left, key);
				return search;
			} else { 
				BinarySearchTreeNode search = searchBST(root.right, key); 
				return search;
			}
		}
	}
	
	
	//recursion
	public static BinarySearchTreeNode insertBST(BinarySearchTreeNode root,int key){
		
		BinarySearchTreeNode temp = new BinarySearchTreeNode(key);
		
		if(root==null){
			root=temp;
		}
		else if(root.data>=temp.data){
			root.left=insertBST(root.left,key);
		}
		else{
			root.right=insertBST(root.right,key);
		}
		return root;
	}
	
	public static BinarySearchTreeNode insertBSTIteration(BinarySearchTreeNode root,int key){
		
		BinarySearchTreeNode newNode = new BinarySearchTreeNode(key);
		BinarySearchTreeNode parent = root;
		BinarySearchTreeNode temp = root;
		
		
		if(root==null){
			root=newNode;
		}
		
		while(temp!=null){
			parent = temp;
			if(newNode.data <= temp.data){
				temp = temp.left;
			}else{
				temp = temp.right;
			}
		}
		
		if(newNode.data <= parent.data)
			parent.left = newNode;
		else
			parent.right = newNode;
		
		
		return root;
	}
	
	
	//check if binary tree is binary search tree
	public static boolean isBST(BinarySearchTreeNode root, int min, int max){
		
		if(root == null)
			return true;
		
		int data = Integer.valueOf(root.data);
		
		if(data<= min || data>max){
			return false;
		}
		
		return isBST(root.left,min, data) && isBST(root.right, data, max);
		
	}
	
	
	public static void levelOrderTraversal(BinarySearchTreeNode root){
		 Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
		 
		 if(root !=null){
			 q.add(root);
		 }
		 
		 while(!q.isEmpty()){
			
			 root =  q.peek();
			 System.out.print(root.data+" ");
			 
			 //add its child to the queue
			 if(root.left!=null)
				 q.add(root.left);
			 if(root.right!=null)
				 q.add(root.right);
			 
			 //remove element from queue
			 q.remove();
						 
		 }

	}
	
	
	//recursive - in order traversal
	public static void inOrderTraversal(BinarySearchTreeNode root){
		if(root==null){
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	
	
	//recursive - pre order traversal
	public static void preOrderTraversal(BinarySearchTreeNode root){
		if(root==null){
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	//recursive - post order traversal
	public static void postOrderTraversal(BinarySearchTreeNode root){
		if(root==null){
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+" ");
	}
	
	//iterative - post order traversal
	public static void iterativePostOrderTraversal(BinarySearchTreeNode root){
		if(root==null){
			return;
		}
		Stack<BinarySearchTreeNode> st1 = new Stack<BinarySearchTreeNode>();
		Stack<BinarySearchTreeNode> st2 = new Stack<BinarySearchTreeNode>();
		st1.push(root);
		
		while(!st1.isEmpty()){
			root = st1.pop(); //pop from stack1
			st2.push(root); //store in stack2
			//add children of root to stack1
			if(root.left!=null)
				st1.push(root.left);
			if(root.right!=null)
				st1.push(root.right);	
		}
		//print post order traversal
		while(!st2.isEmpty()){
			root = st2.pop();
			System.out.print(root.data+" ");
		}
		
	}
	
	//iterative - pre order traversal
	public static void iterativePreOrderTraversal(BinarySearchTreeNode root){
		if(root==null){
			return;
		}
		Stack<BinarySearchTreeNode> st1 = new Stack<BinarySearchTreeNode>();
		st1.push(root);
		System.out.println("\n\n");
		
		while(!st1.isEmpty()){
			root = st1.pop(); //pop from stack1
			System.out.print(root.data+" ");
	
			//add children of root to stack1
			if(root.right!=null)
				st1.push(root.right);
			if(root.left!=null)
				st1.push(root.left);		
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
	
	public static void printBST(BinarySearchTreeNode root, int count){
		if(root == null){
			for(int i=0; i< count; i++){
				System.out.print("\t");
			}
			System.out.println("null");
		}	
		else{
			
			for(int i=0; i< count; i++){
				System.out.print("\t");
			}
			System.out.println(root.data);
			
			int temp = count+1;
			printBST(root.left,temp);
			printBST(root.right,temp);	
		}
	}//end of printBST()
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTreeNode root = createRandomBinarySearchTree();
		//System.out.println(root.left.data);
		BinarySearchTreeNode search = searchBST(root,60); //search = searchBST(50,60) = 60
		System.out.println("Searched element is: "+search.data); //60
		
		BinarySearchTreeNode newTree = insertBST(root,200);
		System.out.println("After inserting 200: \n\n");
		printBST(newTree,0);
		
		BinarySearchTreeNode newTreeInsert = insertBSTIteration(root,65); 
		System.out.println("After inserting 65: \n\n");
		printBST(newTreeInsert,0);
		
		System.out.println("\n\nIS BT a BST?: "
				+isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		printBST(root,0);
		System.out.println("Level order traversal");
		levelOrderTraversal(root);
		
		System.out.println("\n\nRecursive - In order traversal");
		inOrderTraversal(root);
		
		System.out.println("\n\nRecursive - Pre order traversal");
		preOrderTraversal(root);
		
		System.out.println("\n\nRecursive - Post order traversal");
		postOrderTraversal(root);
		
		System.out.println("\n\nIterative - Post order traversal");
		iterativePostOrderTraversal(root);
		
		System.out.println("\n\nIterative - Pre order traversal");
		iterativePreOrderTraversal(root);
	}
	
	

}
