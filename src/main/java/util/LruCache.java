package util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class LruCache<K,V> {

    static class Node<K,V> {
        K key;
        V value;
        private Node<K,V> prev,next;
        public Node(K key,V value) {
            this.key = key;
            this.value= value;
            this.prev=null;
            this.next=null;
        }
    }

    private final int maxCapacity;
    private ConcurrentHashMap<K,Node<K,V>> map;
    private Node<K,V> head,tail;

    public void removeNode( Node<K,V> node ) {
        if(node == null) return;

        if(node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }

        if(node.next != null)
        {
            node.next.prev= node.prev;
        }else {
            tail = node.prev;
        }
    }

    public void offerNode(Node<K,V> node) {
        if(node ==null) return;
        if(head==null) {
            head = tail =node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }


    public LruCache(int maxCapacity) {
        this(16, maxCapacity);
    }

    public LruCache(int initialCapacity, int maxCapacity) {
        this.maxCapacity = maxCapacity;
        if (initialCapacity > maxCapacity)
            initialCapacity = maxCapacity;
        map = new ConcurrentHashMap<>(initialCapacity);
    }


    public void put(K key, V value) {
        if(map.contains(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            removeNode(node);
            offerNode(node);
        }
        else {
            if (map.size() == maxCapacity) {
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            offerNode(node);
            map.put(key,node);
        }

    }
}
