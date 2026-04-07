package ca.bytetube.ood._19_cachedstoragewrapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache implements Cache {
    int maxSize;
    LinkedHashMap<String, String> map;

    public LRUCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("max size must be positive");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > LRUCache.this.maxSize;
            }
        };

    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Optional<String> get(String key) {
        return Optional.ofNullable(map.get(key));
    }

    @Override
    public int size() {
        return map.size();
    }
}
