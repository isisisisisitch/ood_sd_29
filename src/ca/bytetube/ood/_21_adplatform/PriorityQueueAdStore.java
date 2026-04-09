package ca.bytetube.ood._21_adplatform;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityQueueAdStore implements AdStore {
    private Queue<Ad> heap;
    private ReentrantLock lock = new ReentrantLock();

    public PriorityQueueAdStore(AdPriorityPolicy priorityPolicy) {
        heap = new PriorityQueue<>(Objects.requireNonNull(priorityPolicy));
    }

    @Override
    public void add(Ad ad) {
        Objects.requireNonNull(ad, "ad must not be null!");
        lock.lock();
        try {
            heap.add(ad);

        } finally {
            lock.unlock();
        }

    }

    @Override
    public Ad poll() {
        lock.lock();
        try {
            return heap.poll();

        } finally {
            lock.unlock();
        }


    }

    @Override
    public int size() {
        lock.lock();
        try {
            return heap.size();

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return heap.isEmpty();

        } finally {
            lock.unlock();
        }
    }
}
