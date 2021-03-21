package util;

public class LruNode<K, V> {

    public K key;
    public V value;
    private static LruNode next, prev;
    private static LruNode head, tail;

    public LruNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void removeNode(LruNode node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public static void offerNode(LruNode node) {
        if (node == null) {
            return;
        }
        if (head== null) {
            head= tail = node;
        } else {
            tail.next=node;
            node.prev=tail;
            node.next=null;
            tail=node;
        }
    }
}
