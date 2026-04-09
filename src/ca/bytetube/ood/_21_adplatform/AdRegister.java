package ca.bytetube.ood._21_adplatform;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class AdRegister {
    private AdStore store;
    // private AdPriorityPolicy policy;
    private AtomicLong idGenerator = new AtomicLong(1L);
    private AtomicLong sequecneGenerator = new AtomicLong(1L);

    public AdRegister(AdStore store) {
        this.store = Objects.requireNonNull(store);
    }

    public void insertAd(String content, int score) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("content must not be null or blank!");
        }
        if (score < 0) {
            throw new IllegalArgumentException("score must be >= 0");
        }

        long id = idGenerator.getAndIncrement();
        long sequence = sequecneGenerator.getAndIncrement();
        Ad ad = Ad.of(id, content, score, sequence);

        store.add(ad);
    }

    public Ad getAd() {
        return store.poll();

    }

    public static AdRegister defaultService() {
        AdPriorityPolicy policy = AdPriorityPolicy.defaultPolicy();
        AdStore adStore = new PriorityQueueAdStore(policy);
        return new AdRegister(adStore);
    }


}
