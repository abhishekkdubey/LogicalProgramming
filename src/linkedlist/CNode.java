package linkedlist;

public class CNode {
    public int value;
    public CNode next;

    CNode(int value){
        this.value = value;
        this.next=null;
    }

    @Override
    public String toString() {
        return "CNode{" +
                "value=" + value +
                '}';
    }
}
