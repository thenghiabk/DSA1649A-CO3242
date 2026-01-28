package L02_Node;

class Node<E> {
	// attributes
	public E element;
	public Node<E> next;

	// constructor
	public Node (E element) {
		this.element = element;
		this.next = null;
	}
}

public class NodeExample {
	public static void main (String[] args) {
		Node<Integer> head;
		Node<Integer> n1 = new Node<>(10); // n1.next -> null
		head = n1;
		Node<Integer> n2 = new Node<>(20); // n2.next -> null
		head.next = n2;
		Node<Integer> n3 = new Node<>(30); // n3.next -> null
		head.next.next = n3;

		head.next.next.next = new Node<>(40);


	}
}
