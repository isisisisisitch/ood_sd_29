package ca.bytetube.ood._18_cachedstoragewrapper;

import java.util.Optional;

public class CachedStorageWrapper implements Storage {
    Storage delegate;
    Cache cache;

    public CachedStorageWrapper(Storage delegate, Cache cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    public CachedStorageWrapper(Storage delegate, int maxSize) {
        this.delegate = delegate;
        this.cache = maxSize > 0 ? new LRUCache(maxSize) : new SimpleCache();
    }

    public CachedStorageWrapper(Storage delegate) {
        this(delegate, 1000);
    }

    @Override
    public void write(String key, String value) {
        delegate.write(key, value);
        cache.put(key, value);
    }

    @Override
    public Optional<String> read(String key) {
        //cache hit
        Optional<String> cached = cache.get(key);
        if (cached.isPresent()) return cached;
        //cache miss
        Optional<String> value = delegate.read(key);
        value.ifPresent(v -> cache.put(key, v));
        return value;
    }

    @Override
    public void delete(String key) {

        delegate.delete(key);
        cache.remove(key);
    }

    public int cacheSize() {
        return cache.size();
    }
}
