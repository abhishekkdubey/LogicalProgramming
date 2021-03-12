package linkedlist;

public class DoubleLinkedListMain {

    public static void main(String[] args) {

        DoubleLinkedList dll= new DoubleLinkedList();

        dll.insert(10, 10);
        dll.insert(20, 10);
        dll.insert(30, 10);
        dll.insert(40, 10);
        dll.insert(50, 10);
        dll.insert(60, 10);
//        dll.insert(70, 10);
//        dll.insert(80, 10);
//        dll.insert(90, 10);
//        dll.insert(100, 10);
//        dll.insert(110, 10);
//        dll.insert(120, 10);
//        dll.insert(130, 10);
        dll.traverse();
        dll.reverseTraverse();


    }
}
