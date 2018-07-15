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
	
}


