package L01_ArrayList;

import java.util.Arrays;

class ArrayListADT<E> {
	// attributes
	private E[] elements;
	private int nextIndex;

	// constructor
	public ArrayListADT () {
		elements = (E[]) new Object[5];
		nextIndex = 0;
	}

	// helpers
	public boolean add (E element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null.");
		}
		ensureCapacity();
		this.elements[nextIndex] = element;
		nextIndex++;
		return true;
	}

	public boolean add (int index, E element) {

		if (element == null) {
			throw new NullPointerException("Element cannot be null.");
		}

		ensureCapacity();

		if (index < 0 || index > nextIndex) {
			throw new IndexOutOfBoundsException("Index out of range.");
		}

		// Shift elements to the right
		for (int i = nextIndex; i >= index; i--) {
			elements[i] = elements[i - 1];
		}

		// Insert the new element
		elements[index] = element;
		nextIndex++;

		return true;
	}

	public E get (int index) {
		if (index < 0 || index >= nextIndex) {
			throw new IndexOutOfBoundsException("Index out of range.");
		}

		return this.elements[index];
	}

	public E set (int index, E element) {
		if (element == null) {
			throw new NullPointerException("Element cannot be null.");
		}

		if (index < 0 || index >= nextIndex) {
			throw new IndexOutOfBoundsException("Index out of range.");
		}

		E oldElement = elements[index];

		elements[index] = element;

		return oldElement;

	}

	public E remove (int index) {
		if (index < 0 || index >= nextIndex) {
			throw new IndexOutOfBoundsException("Index out of range.");
		}

		E oldElement = elements[index];

		for (int i = index; i < nextIndex - 1; i++) {
			elements[i] = elements[i + 1];
		}

		elements[nextIndex - 1] = null;
		nextIndex--;

		if (nextIndex <= elements.length / 3) {
			this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
		}

		return oldElement;
	}

	public int size () {
		return nextIndex;
	}

	public boolean isEmpty () {
		// Option 1
		if (nextIndex == 0) {
			return true;
		} else {
			return false;
		}

		// Option 2
		// if (nextIndex == 0) return true;
		// return false;

		// Option 3
		// return nextIndex == 0;
	}

	public int indexOf (E element) {
		for (int i = 0; i < nextIndex; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}

		return -1;
	}

	public boolean contains (E element) {
		for (int i = 0; i < nextIndex; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString () {
		StringBuilder result = new StringBuilder("[");

		for (int i = 0; i < nextIndex; i++) {
			result.append(elements[i]);

			if (i < nextIndex - 1) {
				result.append(", ");
			}
		}

		result.append("]");

		return result.toString();
	}

	private void ensureCapacity () {
		// Check if array is full
		if (nextIndex == elements.length) {

			// Option 1
			// E[] newElements = (E[]) new Object[elements.length * 2];
			//
			// for (int i = 0; i < elements.length; i++){
			//     newElements[i] = elements[i];
			// }
			//
			// this.elements = newElements;

			// Option 2
			// Double the capacity
			int newCapacity = elements.length * 2;

			// Create new array with doubled size and copy existing elements
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
}

public class Main {
	public static void main (String[] args) {
		try {
			ArrayListADT<Integer> myArrayList = new ArrayListADT<>();

			// Test isEmpty() on empty list
			System.out.println("=== Testing isEmpty() ===");
			System.out.println("Is empty: " + myArrayList.isEmpty());
			System.out.println(myArrayList);

			// Test add(E element)
			System.out.println("\n=== Testing add(E element) ===");
			myArrayList.add(10);
			myArrayList.add(20);
			myArrayList.add(30);
			myArrayList.add(40);
			myArrayList.add(50);
			myArrayList.add(60); // Triggers capacity expansion
			System.out.println(myArrayList);

			// Test size()
			System.out.println("\n=== Testing size() ===");
			System.out.println("Size: " + myArrayList.size());

			// Test isEmpty() on non-empty list
			System.out.println("\n=== Testing isEmpty() on non-empty list ===");
			System.out.println("Is empty: " + myArrayList.isEmpty());

			// Test get(int index)
			System.out.println("\n=== Testing get(int index) ===");
			System.out.println("Element at index 3: " + myArrayList.get(3));

			// Test contains(E element)
			System.out.println("\n=== Testing contains(E element) ===");
			System.out.println("Contains 40: " + myArrayList.contains(40));
			System.out.println("Contains 100: " + myArrayList.contains(100));

			// Test indexOf(E element)
			System.out.println("\n=== Testing indexOf(E element) ===");
			System.out.println("Index of 40: " + myArrayList.indexOf(40));
			System.out.println("Index of 100: " + myArrayList.indexOf(100));

			// Test add(int index, E element)
			System.out.println("\n=== Testing add(int index, E element) ===");
			myArrayList.add(2, 25);
			System.out.println("After adding 25 at index 2: " + myArrayList);

			// Test set(int index, E element)
			System.out.println("\n=== Testing set(int index, E element) ===");
			Integer oldValue = myArrayList.set(3, 35);
			System.out.println("Replaced " + oldValue + " with 35 at index 3: " + myArrayList);

			// Test remove(int index)
			System.out.println("\n=== Testing remove(int index) ===");
			Integer removed = myArrayList.remove(1);
			System.out.println("Removed " + removed + " at index 1: " + myArrayList);
			System.out.println("New size: " + myArrayList.size());

			// Test multiple removes to trigger capacity reduction
			System.out.println("\n=== Testing capacity reduction ===");
			myArrayList.remove(0);
			myArrayList.remove(0);
			myArrayList.remove(0);
			System.out.println("After multiple removes: " + myArrayList);
			System.out.println("Final size: " + myArrayList.size());

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace(); // Print stack trace for debugging
		}
	}
}
