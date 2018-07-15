package LinkedList;

public class LinkedList {

	LinkedListNode root;

	public LinkedList(LinkedListNode root) {
		// TODO Auto-generated constructor stub
		this.root = root;

	}

	//perform insertion at beginning
	public void insertionAtBeginning(LinkedListNode node) {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		node.next = root;
		root = node;
		
		System.out.println("Inserted node is: "+node.data);	
	}

	//perform insertion at end
	public void insertionAtEnd(LinkedListNode node) {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		
		LinkedListNode temp = root;
		
		//traverse over LinkedList and find the last element
		while(temp.next != null){
			temp = temp.next;
		}
		//temp will be the last element
		temp.next = node;
				
		System.out.println("\nInserted node is: "+node.data);	
	}

	//perform insertion at end
	public void insertionAtMiddle(LinkedListNode node, LinkedListNode middle) {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		
		LinkedListNode temp = root, prev = root;
		
		//traverse over LinkedList and find the last element
		while(temp.next.data != node.data){
			prev = temp;
			temp = temp.next;
		}
		//temp will be the last element
		prev.next = node;
		node.next = temp;
			
		System.out.println("\nInserted node is: "+node.data);	
	}
	
	
	//perform deleton at beginning
	public void deletionAtBeginning() {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		root = root.next;
	}

	
	//perform deletion at end
	public void deletionAtEnd() {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		
		LinkedListNode temp = root, prev = root;
		
		//traverse over LinkedList and find the last element
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
		}
		//temp will be the last element, prev second 
		prev.next= null;
				
		System.out.println("\nDeleted node is: "+temp.data);	
	}
	
	//perform insertion at end
	public void deletionAtMiddle(LinkedListNode node) {

		if (root == null) {
			System.out.println("Linked List is empty ");
			return;
		}
		
		LinkedListNode temp = root, prev = root;
		
		//traverse over LinkedList and find the last element
		while(temp.next.data != node.data){
			prev = temp;
			temp = temp.next;
		}
		//temp will be the last element
		prev.next = temp.next;
				
		System.out.println("Deleted node is: "+node.data);	
	}
	

	/**
	 * second way:- we will use two pointers one - increment on each iteration
	 * other - incremented every second iteration. so when first pointer will
	 * point to the end of linked list, second will be pointing to the middle
	 * element of linked list
	 * 
	 */
	public void middleNodeInLL() {

		if (root == null) {
			System.out.println("Cannot find middle node in LL! Linked List is empty ");
			return;
		}

		LinkedListNode middle = root, current = root;
		int count = 0;

		while (current != null) {
			count++;
			if (count % 2 == 0) {
				middle = middle.next;
			}
			current = current.next;
		}
		System.out.println("\nMiddle element is " + middle.data);
	}

	/**
	 * second way:- we will use two pointers one - increment on each iteration
	 * other - incremented every second iteration. so when first pointer will
	 * point to the end of linked list, second will be pointing to the middle
	 * element of linked list
	 * 
	 */
	public LinkedListNode middleNodeInLLUsingTwoPointers() {

		if (root == null) {
			System.out.println("Cannot find middle node in LL! Linked List is empty ");
			return null;
		}

		LinkedListNode middle = root, current = root;
		int count = 0;

		while (current != null && current.next!=null ) {
			current = current.next.next;
			middle = middle.next;
		}
		System.out.println("\nMiddle element is " + middle.data);
		return middle;
	}

	/**
	 * Traverse through a linked list input: root (Reference to linked list)
	 */
	public void linkedListTraversal() {
		if (root == null)
			System.out.println("\nLinked List is empty! Cannot traverse!");
		else {
			int count = 0;
			System.out.print("\nNodes: \t\t");
			LinkedListNode temp = root;
			while (temp.next != null) {
				System.out.print(temp.data + " ---> ");
				temp = temp.next;
			}
			System.out.print(temp.data); // print last node
			System.out.println();
			System.out.print("i:     \t\t");
			// print index
			temp = root;
			while (temp.next != null) {
				System.out.print(count++ + "      ");
				temp = temp.next;
			}
			System.out.print(count); // print last node
		}
	}

	/**
	 * Creates a linked list with values 1-10
	 * 
	 * @return Linked List(root)
	 */
	public static LinkedListNode createRandomLinkedList() {
		LinkedListNode eleventh = new LinkedListNode(11);
		LinkedListNode tenth = new LinkedListNode(10, eleventh);
		LinkedListNode ninth = new LinkedListNode(9, tenth);
		LinkedListNode eighth = new LinkedListNode(8, ninth);
		LinkedListNode seventh = new LinkedListNode(7, eighth);
		LinkedListNode sixth = new LinkedListNode(6, seventh);
		LinkedListNode fifth = new LinkedListNode(5, sixth);
		LinkedListNode fourth = new LinkedListNode(4, fifth);
		LinkedListNode third = new LinkedListNode(3, fourth);
		LinkedListNode second = new LinkedListNode(2, third);
		LinkedListNode root = new LinkedListNode(1, second);
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListNode root = createRandomLinkedList();
		LinkedList linkedList = new LinkedList(root);

		// print Linked List
		System.out.println("Linked list :");
		linkedList.linkedListTraversal();

		System.out.println("\n\nMiddle element of LL");
		linkedList.middleNodeInLLUsingTwoPointers();
		
		//insertion at beginning
		LinkedListNode node1 = new LinkedListNode(100,null);
		linkedList.insertionAtBeginning(node1);
		linkedList.linkedListTraversal();
		
		//insertion at end
		LinkedListNode node2 = new LinkedListNode(200,null);
		linkedList.insertionAtEnd(node2);
		linkedList.linkedListTraversal();
		
		//insertion at middle
		LinkedListNode node3 = new LinkedListNode(200,null);
		linkedList.insertionAtEnd(node3);
		linkedList.linkedListTraversal();

	}

}
