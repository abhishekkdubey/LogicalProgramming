package linkedlist;

public class CircularLinkedList {

    private int size;
    private CNode head;
    private CNode tail;


    public CircularLinkedList() {

    }

    public CNode getHead() {
        return head;
    }

    public CNode getTail() {
        return tail;
    }

    public void insert(int value, int position) {
        CNode newNode = new CNode(value);
        if (size == 0) {
            head = newNode;
            newNode.next = newNode;
            tail = newNode;
            size++;
            System.out.println("Value " + value + " Inserted on position " + 0 + " Successfully!!");
            return;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
            size++;
        } else if (position >= size - 1) {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
            size++;
            System.out.println("Value " + value + " Inserted on position " + size + " Successfully!!");
            return;
        } else {
            int index = 0;
            CNode tempNode = head;
            while (index < position - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
        }
        System.out.println("Value " + value + " Inserted on position " + position + " Successfully!!");
    }

    public int getSize() {
        return size;
    }

    public void traverse() {
        int index = 0;
        CNode node = head;
        System.out.println("Traversing Circular LinkedList");
        while (index < size) {
            if (index == size - 1) {
                System.out.print(node.value);
            } else {
                System.out.print(node.value + " -> ");
            }
            node = node.next;
            index++;
        }
        System.out.println();
    }

    public void search(int value) {
        if (head != null) {
            CNode tempValue = head;
            for (int i = 0; i < size; i++) {
                if (tempValue.value == value) {
                    System.out.println("Value found at index: " + i);
                    return;
                }
                tempValue = tempValue.next;
            }
            System.out.println("Value not found!!");
        }

    }

    /**
     * Delete Node from given position
     *
     * @param position must be between 0 to size-1
     */
    public void delete(int position) {
        if (head == null || position >= size) {
            throw new IllegalArgumentException("Invalid position, it must be between 0 to size-1");
        }

        if (position == 0) {
            if (size == 1) {
                head = tail = head.next = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else if (position == size - 1) {

            CNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = head;
            tail = tempNode;
        } else {
            CNode tempNode = head;
            for (int i = 0; i < position - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
        }
        size--;
        System.out.println("Deleted Node from position " + position + " Successfully!!");
    }

    public void clear() {
        head = null;
        tail.next = null;
        tail = null;
        size = 0;
        System.out.println("Deleted all Nodes Successfully!!");
    }

}
