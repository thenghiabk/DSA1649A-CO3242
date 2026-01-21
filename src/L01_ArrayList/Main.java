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

        this.elements[nextIndex] = element;
        nextIndex++;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        try{
            ArrayListADT<Integer> myArrayList = new ArrayListADT<>();
            myArrayList.add(10);
            myArrayList.add(20);
            myArrayList.add(30);
            myArrayList.add(40);
            myArrayList.add(50);
            myArrayList.add(60);
            System.out.println();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
