package linkedlist;

public class SingleLinkedList {


    SingleNode head;
    SingleNode tail;
    int size = 0;


    public SingleLinkedList() {

    }

    public SingleNode getHead() {
        return head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void insert(int value) {
        SingleNode node = new SingleNode(value);
        if (head == null && tail == null) {
            head = tail = node;

        } else {
            tail.next = node;
            tail = node;
        }
        System.out.println("Insert " + value + " Successfully!!");
        size++;
    }

    public void insertToFirst(int value) {
        SingleNode node = new SingleNode(value);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        System.out.println("Insert " + value + " on starting of Linked List Successfully!!");
        size++;
    }

    public int getSize() {
        return size;
    }


    public void insertToPosition(int value, int pos) {
        if (pos == 0) {
            insertToFirst(value);
        } else if (pos >= size) {
            insert(value);
        } else {
            SingleNode newNode = new SingleNode(value);
            SingleNode tempNode = head;
            int count = 0;
            while (count < pos - 1) {
                tempNode = tempNode.next;
                count++;
            }//Here temp hold the Node value where after I need to insert the value of new Node
            SingleNode nextNode = tempNode.next; // Storing immediate next node reference to next which will connect to new node
            tempNode.next = newNode; // assigning new node to the next of pos node
            newNode.next = nextNode; // Assigning next to new node the next values
            System.out.println("Insert " + value + " to position " + pos + " Successfully!!");
            size++;
        }
    }

    public void traverse() {
        traverseNode(head);
    }

    /**
     * Traversing Node
     * @param node
     */
    public void traverseNode(SingleNode node) {
        System.out.println("Traversing values ");
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.value + " ");
            } else {
                System.out.print(node.value + " -> ");
            }
            node = node.next;
        }
        System.out.println();

    }


    /**
     * Delete Node from Single Linked List
     * @param pos
     */
    public void delete(int pos) {
        if (pos == 0) {
            deleteFirst();
        } else if (pos == size - 1) {
            deleteLast();
        } else if (pos > 0 && pos < size) {
            SingleNode tempNode = head;
            int index = 0;
            while (index < pos - 1) {
                tempNode = tempNode.next;
                index++;
            }
            System.out.println("Deleted value " + tempNode.next.value + " from position " + pos + " Successfully!!");
            tempNode.next = tempNode.next.next;
            size--;
        } else {
            System.out.println("Position " + pos + " is out of scope!!");
        }

    }

    /**
     * Delete Last Node
     */
    public void deleteLast() {
        SingleNode tempNode = head;
        int index = 1;
        while (index < size - 1) {
            tempNode = tempNode.next;
            index++;
        }
        System.out.println("Deleted value " + tempNode.next.value + " from position " + (size - 1) + " Successfully!!");
        tempNode.next = null;
        tail = tempNode;
        size--;

    }

    /**
     * Delete First Node
     */
    public void deleteFirst() {
        if (size == 1) {
            System.out.println("Deleted value " + head.value + " from position " + (size - 1) + " Successfully!!");
            head = null;
            tail = null;
        } else {
            SingleNode nextNode = head.next;
            System.out.println("Deleted value " + head.value + " from position " + 1 + " Successfully!!");
            head.next = null;
            head = nextNode;
        }
        size--;
    }

    /**
     * Delete Node from specific position
     * @param pos integer value of position starting from index 0.. size - 1
     */
    public void deleteNode(int pos) {
        if (head == null || pos > size-1) {
            System.out.println("LinkedList does not exists or invalid position!!");

        } else if (pos == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
            size--;
        } else if (pos >= size - 1) {
            if (head == tail) {
                head = tail = null;
            } else {
                int index = 1;
                SingleNode tempNode = head;
                while (index < size - 1) {
                    tempNode = tempNode.next;
                    index++;
                }
                tail = tempNode;
                tempNode.next = null;
            }
            size--;
        }else{
            int index = 0;
            SingleNode tempNode = head;
            while (index < pos - 1) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
        System.out.println("Deleted value from position " + pos + " Successfully!!");
    }

    public void search(int value){
        if (head != null) {
            int index = 0;
            SingleNode node = head;
            while (index < size - 1) {
                if (value == node.value) {
                    System.out.println("Value found on position " + index);
                    return;
                }
                node= node.next;
                index++;
            }
        }
        System.out.println("Value not found!!");
    }

    /**
     * Delete complete Single Linked List
     */
    public void clear(){
        head = null;
        tail= null;
        size=0;
    }


}


