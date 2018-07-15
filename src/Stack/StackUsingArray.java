package Stack;

import java.util.NoSuchElementException;

public class StackUsingArray {

	int top;
	int size;
	int stack[];


	public StackUsingArray() {
		top = -1;
		size = 3;
		stack = new int[size];
	}

	public StackUsingArray(int size) {
		top = -1;
		this.size = size;
		stack = new int[size];
	}


	public void push(int value){
		//check if stack is full
		if (top == size-1){
			System.out.println("Stack is full!");
			throw new NoSuchElementException("Stack overflow");
		}
		else{
			top += 1;
			stack[top] = value;
		}
	}

	public int pop(){
		//check if stack is empty
		int value = Integer.MIN_VALUE;
		if (top == -1){
			System.out.println("Stack is empty!");
			throw new NoSuchElementException("Stack underflow");
		}
		else{
			value = stack[top];
			System.out.println("Deleted value from "+top+" is "+value);
			top--;
		}
		return value;
	}


	public int peek(){
		//check if stack is empty
		if (top == -1){
			System.out.println("Stack is empty!");
			throw new NoSuchElementException("Stack underflow");
		}
		else{
			System.out.println("Value at "+top+" is "+stack[top]);
			return stack[top];
		}
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public int size(){
		return this.size;
	}

	public void traverse(){
		for( int i : stack){
			System.out.print(i+" ");
		}
	}

	public static void main(String[] args) {

		StackUsingArray stack1 = new StackUsingArray();
		stack1.traverse();;
		stack1.push(1);
		stack1.push(2);
		stack1.traverse();
		stack1.pop();
		stack1.peek();
		stack1.push(3);
		stack1.push(3);
		stack1.traverse();
		
	}

}
