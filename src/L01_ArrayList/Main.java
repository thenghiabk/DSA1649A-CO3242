package L01_ArrayList;

import java.util.Arrays;

class ArrayListADT<E> {
    // attributes
    private E[] elements;
    private int nextIndex;

    // constructor
    public ArrayListADT(){
        elements = (E[]) new Object[5];
        nextIndex = 0;
    }

    // helpers
    public boolean add(E element){
        if (element == null){
            throw new NullPointerException("Element cannot be null.");
        }
        ensureCapacity();
        this.elements[nextIndex] = element;
        nextIndex++;
        return true;
    }

    public boolean add(int index, E element){

        if (element == null){
            throw new NullPointerException("Element cannot be null.");
        }

        ensureCapacity();

        if (index < 0 || index > nextIndex){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        // Shift elements to the right
        for (int i = nextIndex; i >= index; i--){
            elements[i] = elements[i-1];
        }

        // Insert the new element
        elements[index] = element;
        nextIndex++;

        return true;
    }

    public E get(int index){
        if (index < 0 || index > nextIndex){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        return this.elements[index];
    }

    public E set(int index, E element){
        if (element == null){
            throw new NullPointerException("Element cannot be null.");
        }

        if (index < 0 || index > nextIndex){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        E oldElement = elements[index];

        elements[index] = element;

        return oldElement;

    }

    public E remove(int index){
        if (index < 0 || index > nextIndex){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        E oldElement = elements[index];

        for (int i = index; i < nextIndex - 1; i++){
            elements[i] = elements[i+1];
        }

        elements[nextIndex-1] = null;
        nextIndex--;

        if (nextIndex <= elements.length / 3){
            this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
        }

        return oldElement;
    }

    public int size(){
        return nextIndex;
    }

    public boolean isEmpty(){
        // Option 1
        if (nextIndex == 0){
            return true;
        } else {
            return false;
        }

        // Option 2
//        if (nextIndex == 0) return true;
//        return false;

        // Option 3
//        return nextIndex == 0;
    }

    public int indexOf(E element){
        for (int i = 0; i < nextIndex; i++){
            if (elements[i].equals(element)){
                return i;
            }
        }

        return -1;
    }

    public boolean contains(E element){
        for (int i = 0; i < nextIndex; i++){
            if (elements[i].equals(element)){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < nextIndex; i++){
            sb.append(elements[i]);

            if (i < nextIndex - 1)
                sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }

    private void ensureCapacity(){
        if (nextIndex == elements.length){

            // Option 1
//            E[] newElements = (E[]) new Object[elements.length * 2];
//
//            for (int i = 0; i < elements.length; i++){
//                newElements[i] = elements[i];
//            }
//
//            this.elements = newElements;

            // Option 2
            this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try{
            ArrayListADT<Integer> myArrayList = new ArrayListADT<>();

            if (myArrayList.isEmpty()){
                System.out.println("The ArrayList is empty");
            }

            System.out.println(myArrayList);

            myArrayList.add(10);
            myArrayList.add(20);
            myArrayList.add(30);
            myArrayList.add(40);
            myArrayList.add(50);
            myArrayList.add(60); // length = 10

            System.out.println(myArrayList);

            if (myArrayList.contains(40)){
                System.out.println("40 is the ArrayList");
            }

            int index = myArrayList.indexOf(40);
            if (index == -1) {
                System.out.println("40 is the ArrayList");
            } else {
                System.out.println("40 is at the index " + index + " in the ArrayList");
            }


            System.out.println();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
