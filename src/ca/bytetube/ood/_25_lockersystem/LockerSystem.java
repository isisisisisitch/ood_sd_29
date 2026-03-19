package ca.bytetube.ood._25_lockersystem;

import java.util.*;
import java.util.function.Function;

public class LockerSystem {
    private Map<String, Locker> allLockers;
    private Map<String, Locker> occupiedLockers;

    //ceilingKey can quickly find the smallest suitable locker in O(logn)
    private TreeMap<Integer, List<Locker>> availableLockersBySize;

    public LockerSystem() {
        this.allLockers = new HashMap<>();
        this.occupiedLockers = new HashMap<>();
        this.availableLockersBySize = new TreeMap<>();

    }


    public void addLocker(Locker locker) {
        allLockers.put(locker.getId(), locker);
        addToAvailableLockers(locker);
    }

    private void addToAvailableLockers(Locker locker) {
        int size = locker.getSize();
        availableLockersBySize.computeIfAbsent(size, integer -> new ArrayList<>()).add(locker);
    }

    public Locker findAvailableLocker(Package pkg) {
        Integer suitableSize = availableLockersBySize.ceilingKey(pkg.getSize());
        if (suitableSize == null) return null;

        List<Locker> lockersOfSize = availableLockersBySize.get(suitableSize);
        if (lockersOfSize == null || lockersOfSize.isEmpty()) {
            return null;
        }

        return lockersOfSize.get(0);

    }

    public boolean assignLocker(Package pkg) {
        Locker availableLocker = findAvailableLocker(pkg);
        if (availableLocker == null) {
            System.out.println(" no available locker found for package:" + pkg.getId());
            return false;
        }

        if (availableLocker.storePackage(pkg)) {
            occupiedLockers.put(availableLocker.getId(), availableLocker);
            removeFromAvailableLockers(availableLocker);
            System.out.println("Package:" + pkg.getId() + " assigned to locker " + availableLocker.getId());
            return true;
        }

        return false;

    }

    private void removeFromAvailableLockers(Locker locker) {
        int size = locker.getSize();
        List<Locker> lockersOfSize = availableLockersBySize.get(size);
        if (lockersOfSize != null) {
            lockersOfSize.remove(locker);
            if (lockersOfSize.isEmpty()) {
                availableLockersBySize.remove(size);
            }
        }
    }


    public Package releaseLocker(String lockerId) {
        Locker locker = occupiedLockers.get(lockerId);
        if (locker == null) {
            System.out.println("Locker " + lockerId + " is not occupied");
            return null;
        }

        Package pkg = locker.retrievePackage();
        occupiedLockers.remove(locker.getId());
        addToAvailableLockers(locker);
        System.out.println("Released locker " + lockerId + ", retrieved package " + pkg);
        return pkg;
    }

    /**
     * Get recommended locker size distribution
     */
    public Map<Integer, Integer> getRecommendedLockerDistribution() {
        Map<Integer, Integer> distribution = new HashMap<>();
        distribution.put(10, 20);  // Small lockers - 20 units
        distribution.put(20, 15);  // Medium lockers - 15 units
        distribution.put(30, 10);  // Large lockers - 10 units
        distribution.put(50, 5);   // Extra large lockers - 5 units

        return distribution;
    }

    /**
     * Get system status statistics
     */
    public void printSystemStatus() {
        System.out.println("\n=== Locker System Status ===");
        System.out.println("Total lockers: " + allLockers.size());
        System.out.println("Occupied lockers: " + occupiedLockers.size());

        int totalAvailable = availableLockersBySize.values().stream().mapToInt(List::size).sum();
        System.out.println("Available lockers: " + totalAvailable);
        System.out.println("\nAvailable lockers by size distribution:");
        for (Map.Entry<Integer, List<Locker>> entry : availableLockersBySize.entrySet()) {
            System.out.println("  Size " + entry.getKey() + ": " + entry.getValue().size() + " units");
        }

        if (!occupiedLockers.isEmpty()) {
            System.out.println("\nOccupied lockers:");
            for (Locker locker : occupiedLockers.values()) {
                System.out.println("  " + locker);
            }
        }
        System.out.println("===========================\n");
    }
}
