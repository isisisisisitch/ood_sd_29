package ca.bytetube.ood._21_adplatform;

public interface AdStore {
    void add(Ad ad);

    Ad poll();

    int size();

    boolean isEmpty();
}
