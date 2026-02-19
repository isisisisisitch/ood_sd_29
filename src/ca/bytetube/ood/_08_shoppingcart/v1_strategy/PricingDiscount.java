package ca.bytetube.ood._08_shoppingcart.v1_strategy;

import ca.bytetube.ood._08_shoppingcart.model.CartItem;

import java.util.List;

public interface PricingDiscount {
    double apply(List<CartItem> items, double currentTotal);
}
