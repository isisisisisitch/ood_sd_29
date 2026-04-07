package ca.bytetube.ood._18_amazonproducteventrouter;

public interface Condition {
    boolean matches(ProductEvent event);
}
