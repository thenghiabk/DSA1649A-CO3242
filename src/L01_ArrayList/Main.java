package L01_ArrayList;

class ArrayList<E> {
    // attributes
    private E[] elements;
    private int nextIndex;

    // constructor
    public ArrayList(){
        elements = (E[]) new Object[5];
        nextIndex = 0;
    }

    // helpers
    public boolean add(E element){
        this.elements[nextIndex] = element;
        nextIndex++;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
