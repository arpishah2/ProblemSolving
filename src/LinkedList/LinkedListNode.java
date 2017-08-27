/**
 * Linked List Implementation
 */
package LinkedList;

import java.util.LinkedList;

/**
 * @author arpi
 *
 */
public class LinkedListNode {

	int data;
	LinkedListNode next;

	
	/**
	 *  value of node = 0, no next node
	 */
	public LinkedListNode() {
		this.data = 0;
		this.next = null;
	}
	
	
	/**
	 *  Parameterized constructor
	 *  value of node = input_data, no next node
	 */
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 *  Parameterized constructor
	 *  value of node = input_data, next=input_next
	 */
	public LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	
	/**
	 * second way:-
	 * we will use two pointers
     * one - increment on each iteration 
     * other - incremented every second iteration. 
     * so when first pointer will point to the end of linked list, 
     * second will be pointing to the middle element of linked list
     * 
     */
	public static void middleNodeInLL(LinkedListNode root){
		
		if(root==null){
			System.out.println("Cannot find middle node in LL! Linked List is empty ");
			return;
		}
		
		LinkedListNode middle = root, current = root;
		int count = 0;

		while(current!=null){
			count++;
			if(count%2==0){
				middle = middle.next;
			}	
			current=current.next;
		}
		System.out.println("Middle element is "+middle.data);
	}
	
	/**
	 * Traverse through a linked list
	 * input: root (Reference to linked list)
	 */
	public static void linkedListTraversal(LinkedListNode root){
		if(root == null)
			System.out.println("Linked List is empty! Cannot traverse!");
		else{
			int count=0;
			System.out.print("Nodes: \t\t");
			LinkedListNode temp = root;
			while(temp.next!=null){
				System.out.print(temp.data+" ---> ");
				temp = temp.next;
			}
			System.out.print(temp.data);	 //print last node
			System.out.println();
			System.out.print("i:     \t\t");
			//print index
			temp = root;
			while(temp.next!=null){
				System.out.print(count+++"      ");
				temp = temp.next;
			}
			System.out.print(count); //print last node
		}
	}

	
	/**
	 * Creates a linked list with values 1-10
	 * @return Linked List(root)
	 */
	public static LinkedListNode createRandomLinkedList() {
		LinkedListNode eleventh = new LinkedListNode(11);
		LinkedListNode tenth = new LinkedListNode(10,eleventh);
		LinkedListNode ninth = new LinkedListNode(9, tenth);
		LinkedListNode eighth = new LinkedListNode(8, ninth);
		LinkedListNode seventh = new LinkedListNode(7, eighth);
		LinkedListNode sixth = new LinkedListNode(6, seventh);
		LinkedListNode fifth = new LinkedListNode(5, sixth);
		LinkedListNode fourth = new LinkedListNode(4, fifth);
		LinkedListNode third = new LinkedListNode(3, fourth);
		LinkedListNode second = new LinkedListNode(2, third);
		LinkedListNode root = new LinkedListNode(1,second);
		return root;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		LinkedListNode root = createRandomLinkedList();
		
		//print Linked List
		System.out.println("Linked list :");
		linkedListTraversal(root);
		
		System.out.println("\n\nMiddle element of LL");
		middleNodeInLL(root);

		
	}


	
}
