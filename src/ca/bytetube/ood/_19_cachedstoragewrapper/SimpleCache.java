package ca.bytetube.ood._19_cachedstoragewrapper;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache implements Cache {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

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
