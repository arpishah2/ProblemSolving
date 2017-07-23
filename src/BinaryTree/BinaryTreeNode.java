package BinaryTree;

/*
 * Tree :-> 
5 
	10 
		20 
			40 
				null
				null
			null
		25 
			null
			null
	15 
		30 
			null
			null
		35 
			null
			null



In order traversal: 
40	20	10	25	5	30	15	35	

Pre order traversal: 
5	10	20	40	25	15	30	35	

Ppst order traversal: 
40	20	25	10	30	35	15	5	

 */


public class BinaryTreeNode {

	String data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode (String data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
		
		//System.out.println(this.data);
	}
	
	public static BinaryTreeNode createRandomBinaryTree(){
		BinaryTreeNode left4 = new BinaryTreeNode("40", null, null);
		
		BinaryTreeNode left3 = new BinaryTreeNode("30", null, null);
		BinaryTreeNode right3 = new BinaryTreeNode("35", null, null);
		
		BinaryTreeNode left2 = new BinaryTreeNode("20", left4, null);
		BinaryTreeNode right2 = new BinaryTreeNode("25", null, null);		
		
		BinaryTreeNode left1 = new BinaryTreeNode("10", left2, right2);
		BinaryTreeNode right1 = new BinaryTreeNode("15", left3, right3);
		
		BinaryTreeNode root = new BinaryTreeNode("5", left1, right1);
		return root;
	}
		
	public static boolean sameBinaryTree(BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 ==null)
			return false;
			
		return node1.data == node2.data 
				&& sameBinaryTree(node1.left,node2.left) 
				&& sameBinaryTree(node1.right,node2.right);
		
	}
	
	
	public static int sizeOfTree(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
	}
	
	public static int heightOfTree(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		return 1+Math.max(heightOfTree(root.left),heightOfTree(root.right));
	}
	
	public static void preOrder(BinaryTreeNode node){
		if(node!=null){
			System.out.print(node.data+" ");
			preOrder(node.left);
			preOrder(node.right);
		}else{
			System.out.print("null ");
		}
	}
	
	public static void inOrder(BinaryTreeNode node){
		if(node!=null){
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}else{
			System.out.print("null ");
		}
	}
	
	public static void postOrder(BinaryTreeNode node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" ");
		}else{
			System.out.print("null ");
		}
	}
	
	//Check and print the branch that sums upto a value 'sum'
	public static boolean rootToLeftSumBT(BinaryTreeNode root, int sum){
		
		if(root==null)
			return false;
		
		int data = Integer.parseInt(root.data); //string value to int 
		
		if(root.left==null && root.right==null){ //leaf node 
			if(data == sum){
				System.out.println(root.data);
				return true;
			}
			return false;
		}
		
		boolean left = rootToLeftSumBT(root.left,sum-data);
		boolean right = rootToLeftSumBT(root.right,sum-data);
		
		if(left||right){
			System.out.println(root.data);	
			return true;
		}
		return false;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode node = createRandomBinaryTree();
		System.out.println("\nPreorder: ");
		preOrder(node);
		System.out.println("\n\nInorder: ");
		inOrder(node);
		System.out.println("\n\nPostorder: ");
		postOrder(node);
		
		System.out.println("\n\nHeight of tree:"+heightOfTree(node));
		System.out.println("\n\nSize of tree:"+sizeOfTree(node));
		
		System.out.println("\n\nCheck if two tree are same binary trees: ");
		BinaryTreeNode tree1 = createRandomBinaryTree();
		BinaryTreeNode tree2 = createRandomBinaryTree();
		tree2.left.left.data = "0";
		System.out.println(sameBinaryTree(tree1,tree2));
		
		System.out.println("\n\nRoot to leaf sum BT=40?: ");
		System.out.println(rootToLeftSumBT(node,50));
		
		
	}

}