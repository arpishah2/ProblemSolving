package Queue;

public class QueueUsingArray {

	int front;
	int rear;
	int queue[];
	int size;
	
	public QueueUsingArray() {
		front = -1;
		rear = -1;
		size = 5;
		queue = new int[5];
	}
	
	public boolean isEmpty(){
		if(front == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull(){
		//even if front!= size-1, and rear == size-1, queue is full
		
		if(rear == size-1)
			return true;
		else
			return false;
	}
	
	public void enqueue(int value){
		
		//queue is full
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		
		if(isEmpty()){	//1st element insertion
			front = rear = 0;
		}
		else{
			rear++;
		}
		queue[rear] = value;
		System.out.println("Value inserted is "+value);
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty /n");
			return -1;
		}
		int value = queue[front];
		if(front == rear){
			front = rear = -1;
		}
		else{
			front++;
		}
		System.out.println("Deleted value is "+value);
		return value;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return queue[rear];
	}
	
	public int noOfElements(){
		return rear-front+1;
	}
	
	
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		for(int i=front; i<=rear; i++){
			System.out.print(queue[i]+ " ");
		}
		
	}
	
	public static void main(String args[]){
		QueueUsingArray queue1 = new QueueUsingArray();
		queue1.display();
		queue1.enqueue(0);
		queue1.enqueue(2);
		System.out.println("No of elements in queue "+queue1.noOfElements());
		queue1.display();
		queue1.dequeue();
		queue1.display();
		queue1.peek();
		System.out.println("No of elements in queue "+queue1.noOfElements());
		queue1.isEmpty();
		queue1.isFull();
	}

}
