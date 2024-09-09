package application;
//Node of Martyrs
class DoublyLinkedListNode {

	private Martyr martyr;
	private DoublyLinkedListNode prev;
	private DoublyLinkedListNode next;

	public DoublyLinkedListNode(Martyr martyr) {
		this.martyr = martyr;
		this.prev = null;
		this.next = null;
	}

	public Martyr getMartyr() {
		return martyr;
	}

	public DoublyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}
}
