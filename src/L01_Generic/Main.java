package L01_Generic;

class Box<E> {
    // attributes
    private E content;

    // constructor
    public Box(E content){
        this.content = content;
    }

    // helpers
    public E getContent(){
        return content;
    }
}


public class Main {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(2026);
        System.out.println(b1.getContent());

        Box<String> b2 = new Box<>("Hello");
        System.out.println(b2.getContent());
    }
}
