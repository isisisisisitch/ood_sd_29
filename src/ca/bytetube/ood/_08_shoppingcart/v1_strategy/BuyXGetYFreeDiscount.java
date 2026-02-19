package ca.bytetube.ood._08_shoppingcart.v1_strategy;

import ca.bytetube.ood._08_shoppingcart.model.CartItem;

import java.util.List;

public class BuyXGetYFreeDiscount implements PricingDiscount {
    private String productId;
    private int buyX;
    private int getY;

    public BuyXGetYFreeDiscount(String productId, int buyX, int getY) {
        if (buyX <= 0 || getY < 0) throw new IllegalArgumentException("invalid x or y");
        this.productId = productId;
        this.buyX = buyX;
        this.getY = getY;
    }

    @Override
    public double apply(List<CartItem> items, double currentTotal) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(productId)) {
                int group = buyX + getY;
                int quantity = item.getQuantity();
                int freeUnits = (quantity / group) * getY;
                double discount = freeUnits * item.getProduct().getUnitPrice();
                return Math.max(0, currentTotal - discount);
            }
        }
        return currentTotal;
    }
}
