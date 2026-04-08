package ca.bytetube.ood._18_amazonproducteventrouter.services;

import ca.bytetube.ood._18_amazonproducteventrouter.DownstreamService;
import ca.bytetube.ood._18_amazonproducteventrouter.ProductEvent;

public class CatalogService implements DownstreamService {
    @Override
    public String name() {
        return "CatalogService";
    }

    @Override
    public void handle(ProductEvent event) {
        System.out.println("CatalogService update catalog" + event);
    }
}
