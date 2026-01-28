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
	public void AddFirst (E element) {
		Node<E> newNode = new Node<>(element);

		// if list is empty
		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		} else { // if list is not empty
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void AddLast (E element) {
		Node<E> newNode = new Node<>(element);

		// if list is empty
		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
		} else { // if list is not empty
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public E removeFirst () {
		// if list is empty
		if (head == null && tail == null) {
			throw new IllegalStateException("List is empty.");
		}

		E oldElement = head.element;

		if (head == tail) { // if list has only one element
			head = null;
			tail = null;
		} else { // if list has more than one element
			Node<E> tempNode = head;
			head = head.next;
			tempNode.next = null;
		}

		size--;
		return oldElement;
	}

	public E removeLast () {
		// if list is empty
		if (head == null && tail == null) {
			throw new IllegalStateException("List is empty.");
		}

		E oldElement = tail.element;

		if (head == tail) { // if list has only one element
			head = null;
			tail = null;
		} else { // if list has more than one element
			Node<E> tempNode = head;
			while (tempNode.next != tail) {
				tempNode = tempNode.next;
			}
			tail = tempNode;
			tail.next = null;
		}

		size--;
		return oldElement;
	}

	public int size () {
		return size;
	}

	public boolean isEmpty () {
		return head == null && tail == null;
	}

	public E getFirst () {
		// if list is empty
		if (head == null && tail == null) {
			throw new IllegalStateException("List is empty.");
		}

		return head.element;
	}

	public E getLast () {
		// if list is empty
		if (head == null && tail == null) {
			throw new IllegalStateException("List is empty.");
		}

		return tail.element;
	}

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
