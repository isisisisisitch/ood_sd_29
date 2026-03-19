package ca.bytetube.ood._25_lockersystem;

public class Locker {
    private int size;
    private String id;
    private Package storePackage;
    private boolean isOccupied;
    private long assignedTime;

    public Locker(int size, String id) {
        this.size = size;
        this.id = id;
        this.storePackage = null;
        this.isOccupied = false;
        this.assignedTime = 0;
    }

    public boolean storePackage(Package pkg) {
        if (!this.isOccupied && this.size >= pkg.getSize()) {
            this.storePackage = pkg;
            this.isOccupied = true;
            this.assignedTime = System.currentTimeMillis();
            return true;
        }

        return false;
    }

    public Package retrievePackage() {
        Package pkg = this.storePackage;
        this.storePackage = null;
        this.isOccupied = false;
        this.assignedTime = 0;
        return pkg;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Package getStorePackage() {
        return storePackage;
    }

    public void setStorePackage(Package storePackage) {
        this.storePackage = storePackage;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public long getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(long assignedTime) {
        this.assignedTime = assignedTime;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "size=" + size +
                ", id='" + id + '\'' +
                ", storePackage=" + storePackage +
                ", isOccupied=" + isOccupied +
                ", assignedTime=" + assignedTime +
                '}';
    }
}
