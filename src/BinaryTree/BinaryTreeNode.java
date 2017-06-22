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
		
	
	public static void preOrder(BinaryTreeNode node){
		if(node!=null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}else{
			System.out.println("null");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode node = createRandomBinaryTree();
		preOrder(node);
		
	}

}