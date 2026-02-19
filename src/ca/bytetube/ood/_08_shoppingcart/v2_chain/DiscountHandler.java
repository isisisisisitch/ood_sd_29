package ca.bytetube.ood._08_shoppingcart.v2_chain;

public interface DiscountHandler {
    void setNext(DiscountHandler next);
    void handle(PricingContext context);
}



