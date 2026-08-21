package com.vpe;

import java.util.HashMap;

/*
    This problem was asked by Google.

    Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n,
    and contain the following methods:
        - set(key, value): sets key to value. If there are already n items in the cache and we are adding
          a new item, then it should also remove the least recently used item.
        - get(key): gets the value at key. If no such key exists, return null.

    Each operation should run in O(1) time.
*/
public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public Integer get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return null;
        }

        moveToFront(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        moveToFront(newNode);

        if (cache.size() > capacity) {
            Node lru = tail.prev;
            cache.remove(lru.key);
            remove(lru);
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
}
