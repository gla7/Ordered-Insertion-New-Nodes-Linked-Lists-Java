
public class LinkedList {// here we learn how to insert elements to a linked list (of ints!) to keep it ordered if it was ordered
	private Node head;
	
	public void insertAtHead (int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public int length () {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	public String toString() {
		String result = "{";
		Node current = this.head;
		
		while (current != null) {
			result = result + current.toString() + ", ";
			current = current.getNextNode();
		}
		result = result + "END}";
		return result;
	}
	
	public void deleteFromHead () {
		this.head = this.head.getNextNode();
	}
	
	public Node find (int searchingForThis) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == searchingForThis) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	// the usual methods above...
	
	public void insertNewElement (int data) {// here the idea is to first check if the head is greater, and if so, replace the head with the element...
		Node newNode = new Node(data);
		Node current = this.head;
		if (current == null) {// if there are no elements in the linked list, put the element at the head
			this.insertAtHead(data);
		}
		while (current != null) {
			if (this.head == current) {// THEN, for every non-head element, check the one after the present element and see if it is greater and if so, place it right before it (reason for this is that LL go forward only, so if we were checking the present element and it turns out to be greater, there is no way to reference the previous element so that that links to the inserted element)
				if (current.getData() > newNode.getData()) {
					this.insertAtHead(data);
					break;
				} else if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			} else {
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			}
			current = current.getNextNode();
		}
	}// this method does ~ 3 + 4*(n-1) + 2 ~ O(n) OR LESS operation to insert an element to a linked list in an ordered fashion, while an array would take necessarily O(n) ALWAYS, since even though searching takes less than that, it has to build a new array with one more element.
	
}
