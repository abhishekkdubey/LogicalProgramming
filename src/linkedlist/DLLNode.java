package linkedlist;

public class DLLNode {

    DLLNode next;
    DLLNode prev;
    int val;

    public DLLNode(int val){
        this.val = val;
        next = prev= null;
    }

}
