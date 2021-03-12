package linkedlist;

public class CircularLinkedListMain {

    public static void main(String[] args) {

        CircularLinkedList cll= new CircularLinkedList();
        cll.insert(10, 0);
        System.out.println("Current head "+cll.getHead() +" tail "+cll.getTail());
        cll.traverse();
        cll.insert(20, 0);
        System.out.println("Current head "+cll.getHead() +" tail "+cll.getTail());
        cll.traverse();
        cll.insert(30, 0);
        System.out.println("Current head "+cll.getHead() +" tail "+cll.getTail());
        cll.traverse();
        cll.insert(40, 0);
        cll.insert(50, 0);
        cll.insert(33, 3);
        cll.insert(55, 100);
        cll.traverse();
        cll.search(33);
        cll.search(88);

        cll.delete(5);
        cll.traverse();
        cll.delete(0);
        cll.traverse();
        cll.delete(0);
        cll.traverse();
        System.out.println("Circular LinkedList Size: "+cll.getSize());
        cll.clear();
        System.out.println("Circular LinkedList Size: "+cll.getSize());




    }
}
