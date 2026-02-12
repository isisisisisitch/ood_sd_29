package ca.bytetube.ood._07_shippingcost;

public interface Package {
    String getDescription();

    double getCost();

    Size getSize();
}
