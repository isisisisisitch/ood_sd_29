package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
    String getDescription();
}
