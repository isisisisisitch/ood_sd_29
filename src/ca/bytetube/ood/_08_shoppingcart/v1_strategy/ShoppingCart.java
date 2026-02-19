package ca.bytetube.ood._08_shoppingcart.v1_strategy;


import ca.bytetube.ood._08_shoppingcart.model.CartItem;
import ca.bytetube.ood._08_shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;
    private List<PricingDiscount> pricingDiscounts;

    public ShoppingCart() {
        items = new ArrayList<>();
        pricingDiscounts = new ArrayList<>();
    }


    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));

    }


    public void addPricingDiscount(PricingDiscount discount) {
        pricingDiscounts.add(discount);
    }

    public double getSubtotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public double getTotalPrice() {
        double total = getSubtotal();
        for (PricingDiscount discount : pricingDiscounts) {
            total = discount.apply(items, total);
        }
        return total;
    }


}
