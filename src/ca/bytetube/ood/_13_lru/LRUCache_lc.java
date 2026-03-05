package ca.bytetube.ood._13_lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_lc {
    private Map<Integer, Node> cache;

    private Node head;
    private Node tail;
    private int capacity;


    public LRUCache_lc(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        //dummyNode
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    //search in the map
    //1.if the key exists: remove the node from the list and then insert it after the head,and return the value of the node
    //2.if the key does exist:return -1
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        addNodeToHead(node);

        return node.value;
    }

    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //1.if the key exists:update the value,remove the existing node and move it to the head
    //2.if the key does not exist:
    //2.1 if the capacity is full:remove the tail.prev(the lru cache) and remove the lru cache from cache map,
    // then insert the new node after the head
    //2.1 if the capacity is not full:insert the new node after the head
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addNodeToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addNodeToHead(newNode);
            cache.put(key, newNode);


        }
    }

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
