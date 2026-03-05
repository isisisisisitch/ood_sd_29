package ca.bytetube.ood._13_lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private int capacity;
    private Map<K, Node<K, V>> cache;
    private DoublyLinkedList<K, V> ddl;
    private static final int DEFAULT_CAPACITY = 2;

    public LRUCache(int capacity) {
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        cache = new HashMap<>();
        ddl = new DoublyLinkedList<>();
    }

    @Override
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) return null;
        node.value.updateAccessTime();
        ddl.removeNode(node);
        ddl.addToFront(node);
        return node.value.getValue();
    }


    @Override
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.value.setValue(value);
            node.value.updateAccessTime();
            ddl.removeNode(node);
            ddl.addToFront(node);
        } else {
            CacheEntry<V> entry = new CacheEntry<V>() {
                private V val = value;
                private long lastAccessTime;

                {
                    updateAccessTime();
                }

                @Override
                public V getValue() {

                    return val;
                }

                @Override
                public void setValue(V value) {
                    this.val = value;
                }

                @Override
                public long getLastAccessTime() {
                    return lastAccessTime;
                }

                @Override
                public void updateAccessTime() {
                    this.lastAccessTime = System.currentTimeMillis();
                }
            };

            node = new Node<>(key, entry);
            if (cache.size() >= capacity) {
                Node<K, V> lru = ddl.removeLast();
                cache.remove(lru.key);
            }
            cache.put(key, node);
            ddl.addToFront(node);
        }
    }

    @Override
    public void remove(K key) {
        Node<K, V> node = cache.remove(key);
        if (node != null) {
            ddl.removeNode(node);
        }
    }

    @Override
    public void clear() {
        cache.clear();
        ddl = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return cache.size();
    }
}
