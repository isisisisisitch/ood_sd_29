package ca.bytetube.ood._08_shoppingcart.v1_strategy;

import ca.bytetube.ood._08_shoppingcart.model.CartItem;

import java.util.List;

public class PercentageOffDiscount implements PricingDiscount {
    private double percentageOff;
    private double minSubTotal;

    public PercentageOffDiscount(double percentageOff, double minSubTotal) {
        if (percentageOff < 0 || percentageOff > 1)
            throw new IllegalArgumentException("percentage must be bewteen 0 and 1 !");
        this.percentageOff = percentageOff;
        this.minSubTotal = minSubTotal;
    }

    @Override
    public double apply(List<CartItem> items, double currentTotal) {
        if (currentTotal >= minSubTotal) {
            return currentTotal * (1 - percentageOff);
        }

        return currentTotal;
    }
}
