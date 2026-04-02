package ca.bytetube.ood._18_cachedstoragewrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class SlowStorageA implements Storage {
    Map<String, String> backend = new HashMap<>();
    long delayMs;

    public SlowStorageA(long delayMs) {
        this.delayMs = delayMs;
    }

    public SlowStorageA() {
        this(100);
    }


    @Override
    public void write(String key, String value) {
        simulateLatency();
        backend.put(key, value);
    }

    private void simulateLatency() {
        try {
            TimeUnit.MILLISECONDS.sleep(delayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<String> read(String key) {
        simulateLatency();
        return Optional.ofNullable(backend.get(key));
    }

    @Override
    public void delete(String key) {
        simulateLatency();
        backend.remove(key);
    }
}
