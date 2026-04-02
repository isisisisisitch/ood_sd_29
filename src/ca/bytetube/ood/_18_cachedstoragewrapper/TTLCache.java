package ca.bytetube.ood._18_cachedstoragewrapper;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TTLCache implements Cache {

    ConcurrentHashMap<String, Entry> map = new ConcurrentHashMap<>();
    long ttMs;

    private static class Entry {
        String value;
        long expireAt;

        public Entry(String value, long expireAt) {
            this.value = value;
            this.expireAt = expireAt;
        }
    }

    public TTLCache(long ttMs) {
        if (ttMs <= 0) {
            throw new IllegalArgumentException("ttMs must be positive");
        }

        this.ttMs = ttMs;

    }

    @Override
    public void put(String key, String value) {
        long expireAt = System.currentTimeMillis() + ttMs;
        map.put(key, new Entry(value, expireAt));
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
        Entry e = map.get(key);
        if (e == null) return Optional.empty();
        if (System.currentTimeMillis() > e.expireAt) {
            map.remove(key);
            return Optional.empty();
        }

        return Optional.of(e.value);
    }

    @Override
    public int size() {
        return map.size();
    }
}
