package Collection;


public class LinkedList {
	private Node head;  
	private Node tail;
	private int size = 0;
	
	private class Node{
		private Object data;
		private Node next;
		private Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;  //새로만들어진 노드의 next값으로 기존의 노드를 가르켜야하는데 기존의 노드가 head에 저장되어있음
		head = newNode;  //head에 새로 추가한 노드를 대입한다
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);  
			//size가 0이면 addFirst로 추가한다.
		}else {
			tail.next = newNode;
			//기존의 tail에서 끝에 붙은 효과를 준다.
			tail = newNode;
			size++;
		}
	}
	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k, Object input) {
		if(k == 0) {
			addFirst(input);
		}else {
			Node temp1 = node(k-1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	public Object removeFirest() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	public Object remove(int k) {
		if(k == 0)
			return removeFirest();
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail)
			tail = temp;
		todoDeleted = null;
		size--;
		return returnData;
	}
	
}



