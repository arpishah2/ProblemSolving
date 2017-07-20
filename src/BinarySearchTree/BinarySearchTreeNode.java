package BinarySearchTree;

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
	}
	
	

}
