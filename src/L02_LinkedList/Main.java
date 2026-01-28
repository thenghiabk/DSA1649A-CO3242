package L02_LinkedList;

class LinkedListADT<E> {
	// attributes
	private Node<E> head;
	private Node<E> tail;
	private int size;

	// constructor
	public LinkedListADT () {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// methods

	// Node
	private class Node<E> {
		// attributes
		private E element;
		private Node<E> next;

		// constructor
		public Node (E element) {
			this.element = element;
			this.next = null;
		}
	}
}

public class Main {
	public static void main (String[] args) {

	}
}
