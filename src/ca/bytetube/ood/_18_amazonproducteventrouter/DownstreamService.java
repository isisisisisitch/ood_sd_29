package ca.bytetube.ood._18_amazonproducteventrouter;

public interface DownstreamService {
    String name();

    void handle(ProductEvent event);

}
