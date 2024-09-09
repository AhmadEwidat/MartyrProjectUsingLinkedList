package application;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

class DoublyLinkedList {
	private DoublyLinkedListNode head;
	private DoublyLinkedListNode tail;
	private String string = new String();

	public DoublyLinkedListNode getHead() {
		return head;
	}

	public void setHead(DoublyLinkedListNode head) {
		this.head = head;
	}

	public DoublyLinkedListNode getTail() {
		return tail;
	}

	public void setTail(DoublyLinkedListNode tail) {
		this.tail = tail;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
//insert Martyr
	public void insertSorted(Martyr martyr) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(martyr);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			DoublyLinkedListNode current = head;
			while (current != null && martyr.getDateOfDeath().compareTo(current.getMartyr().getDateOfDeath()) > 0) {
				current = current.getNext();
			}

			if (current == null) {
				// Insert at the end
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else if (current == head) {
				// Insert at the beginning
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else {
				// Insert in the middle
				newNode.setPrev(current.getPrev());
				newNode.setNext(current);
				current.getPrev().setNext(newNode);
				current.setPrev(newNode);
			}
		}
	}
//to display information from Martyrs
	public void display() {
		string = "";
		DoublyLinkedListNode current = head;
		while (current != null) {

			string += (current.getMartyr() + "\n");

			current = current.getNext();
		}
	}
}
