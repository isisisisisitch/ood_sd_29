package ca.bytetube.ood._05_bookreservation;

import java.util.List;

public class Library {
    private ResourceRegister resourceRegister;

    public Library() {
        this.resourceRegister = new ResourceRegister();
    }

    public List<Resource> search(String name) {
        return resourceRegister.search(name);
    }


    public boolean reserve(String resourceId, String name) {
        return resourceRegister.reserve(resourceId, name);
    }


    public void release(String resourceId, String name) {
        resourceRegister.releaseResource(resourceId, name);
    }


    public void addResource(Resource resource) {
        resourceRegister.addResource(resource);
    }


    public Resource getResource(String resourceId) {
        return resourceRegister.getResource(resourceId);
    }
}
