//package application;
//
//public class Stack {
//	public class Stack {
//		private int size; // number of elements in the stack
//		private Node Front; // pointer to the top node
//
//		public Stack() {
//			// empty stack
//			Front = null;
//			size = 0;
//		}
//		/* Methods go here */
//	}
//
//	public void push(Object element) {
//		Node newNode;
//		newNode = new Node(element);
//		newNode.next = Front;
//		Front = newNode;
//		size++;// update size
//	}
//
//	public Object pop() {
//		if (!isEmpty()) {
//			Node top = Front; // save reference
//			Front = Front.next;// Remove first node
//			size--;
//			return top.element;// Return the element from the saved ref
//		} else
//			return null;
//	}
//
//	public Object peek() {
//		// Return the top element without changing the stack
//		if (!isEmpty())
//			return Front.element;
//		else
//			return null;
//	}
//
//	public int Size() {
//		return size;
//	}
//
//	public boolean isEmpty() {
//		return (Front == null); // return true if the stack is empty
//	}
//}
