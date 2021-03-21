package list;

public class LinkedListNode {

    public LinkedListNode next;
    public LinkedListNode prev;
    public LinkedListNode last;
    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        this.setNext(n);
        this.setPrevious(p);
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LinkedListNode n) {
        next = n;
        if (last == this) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode n) {
        prev = n;
        if (n != null && n.next != this) {
            n.setNext(this);
        }
    }
}
