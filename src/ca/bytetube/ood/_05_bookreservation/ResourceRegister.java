package ca.bytetube.ood._05_bookreservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ResourceRegister {
    private Map<String, Resource> resources;


    public ResourceRegister() {
        resources = new HashMap<>();
    }

    public void addResource(Resource resource) {
        resources.put(resource.getId(), resource);
    }

    public Resource getResource(String resourceId) {
        return resources.get(resourceId);
    }

    public List<Resource> search(String name) {
        return resources.values().stream().filter(r -> r.getName().contains(name)).collect(Collectors.toList());
    }

    public void releaseResource(String resourceId, String name) {
        Resource resource = resources.get(resourceId);
        if (resource == null) return;

        synchronized (resource) {
            resource.setAvailableQuantity(resource.getAvailableQuantity() + 1);
            String nextUser = resource.getWaitingList().peek();
            if (nextUser != null && resource.getAvailableQuantity() > 0) {
                if (reserve(resource.getId(), nextUser)) {
                    resource.getWaitingList().poll();
                }
            }
        }

    }


    public boolean reserve(String resourceId, String name) {
        Resource resource = resources.get(resourceId);
        if (resource == null) return false;

        synchronized (resource) {
            if (resource.getAvailableQuantity() > 0) {
                resource.setAvailableQuantity(resource.getAvailableQuantity() - 1);
                return true;
            } else {
                resource.getWaitingList().offer(name);
                return false;
            }
        }

    }


}
