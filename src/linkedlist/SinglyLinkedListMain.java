package linkedlist;

public class SinglyLinkedListMain {

    public static void main(String[] args) {

//        SingleLinkedList sll= new SingleLinkedList();
//        sll.insert(10);
//        sll.insert(20);
//        sll.insert(30);
//        sll.insert(40);
//        sll.insert(50);
//        sll.insert(60);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();
//        sll.insertToFirst(100);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();
//        sll.insertToPosition(122, 3);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.search(50);
//        sll.search(221);
//        sll.traverse();
//        sll.deleteNode(7);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();
//        sll.deleteNode(3);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();
//        sll.deleteNode(0);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();
//        sll.deleteNode(sll.getSize()-1);
//        System.out.println("LinkedList size: "+sll.getSize());
//        sll.traverse();


        SingleNode node = new SingleNode(1);
        node.next = new SingleNode(2);
        node.next.next= new SingleNode(3);
        reverse(node);
    }


    public static void reverse(SingleNode node){
        new SingleLinkedList().traverseNode(node);
        SingleNode previous = null;
        SingleNode current = node;
        SingleNode next;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        new SingleLinkedList().traverseNode(node);

    }



}
