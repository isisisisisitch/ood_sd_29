package ca.bytetube.ood._18_cachedstoragewrapper;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Backend A: ~100ms per read/write
        Storage slowA = new SlowStorageA(100);
        // Backend B: ~150ms per read/write
        Storage slowB = new SlowStorageB(150);

        // Wrapped with cache: repeated reads hit the cache
        Storage cachedA = new CachedStorageWrapper(slowA, 500);
        Storage cachedB = new CachedStorageWrapper(slowB, 500);

        System.out.println("=== Slow Storage A (no cache) ===");
        long t0 = System.currentTimeMillis();
        slowA.write("k1", "v1");
        slowA.read("k1");
        slowA.read("k1");
        slowA.read("k1");
        long t1 = System.currentTimeMillis();
        System.out.println("Time for 4 operations: " + (t1 - t0) + " ms");

        System.out.println("\n=== CachedStorageWrapper around A ===");
        t0 = System.currentTimeMillis();
        cachedA.write("k1", "v1");   // one slow write
        cachedA.read("k1");          // one slow read + fill cache
        cachedA.read("k1");           // cache hit
        cachedA.read("k1");           // cache hit
        t1 = System.currentTimeMillis();
        System.out.println("Time for 4 operations: " + (t1 - t0) + " ms (last two reads from cache)");
        System.out.println("Cache entry count: " + ((CachedStorageWrapper) cachedA).cacheSize());

        System.out.println("\n=== CachedStorageWrapper around B ===");
        cachedB.write("x", "y");
        Optional<String> opt = cachedB.read("x");
        System.out.println("read(x) = " + opt.orElse("(empty)"));

        // Pluggable cache: LRU or TTL
        System.out.println("\n=== LRUCache (capacity 2, evict least recently used when full) ===");
        Storage withLru = new CachedStorageWrapper(slowA, new LRUCache(2));
        withLru.write("a", "1");
        withLru.write("b", "2");
        withLru.read("a");              // touch a; b becomes LRU
        withLru.write("c", "3");        // full; evict b
        System.out.println("read(b) = " + withLru.read("b").orElse("(miss)"));  // miss
        System.out.println("read(a) = " + withLru.read("a").orElse("(miss)"));  // hit

        System.out.println("\n=== TTLCache (1 second TTL) ===");
        Storage withTtl = new CachedStorageWrapper(slowB, new TTLCache(1000));
        withTtl.write("k", "v");
        System.out.println("read(k) = " + withTtl.read("k").orElse("(empty)"));  // hit
        // If you wait more than 1s before reading again, it misses and goes back to the backend
    }
}
