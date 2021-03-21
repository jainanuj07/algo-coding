package test;

import list.LinkedListNode;
import sun.plugin.javascript.navig4.Link;

public class TestLinkedList {

    public static void main(String args[]) {
        LinkedListNode a = new LinkedListNode(0, null, null);
        LinkedListNode head = a;
        LinkedListNode b = new LinkedListNode(1, null, a);
        LinkedListNode c = new LinkedListNode(2, null, b);

        LinkedListNode ptr = head;
        while (ptr != null) {
            System.out.println("Node ====" + ptr.data);
            ptr = ptr.next;
        }
    }
}
