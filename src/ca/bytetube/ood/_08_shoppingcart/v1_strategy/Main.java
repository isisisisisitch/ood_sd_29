package ca.bytetube.ood._08_shoppingcart.v1_strategy;

import ca.bytetube.ood._08_shoppingcart.model.Product;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product("A1", 1.20, "Apple");
        Product banana = new Product("B1", 0.8, "Banana");
        Product milk = new Product("M1", 3.50, "Milk");

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 3);
        cart.addItem(banana, 5);
        cart.addItem(milk, 2);

        cart.addPricingDiscount(new BuyXGetYFreeDiscount("B1", 2, 1));
        cart.addPricingDiscount(new PercentageOffDiscount(0.10, 10.0));

        System.out.println("subtotal:" + cart.getSubtotal());
        System.out.println("total after discounts:" + cart.getTotalPrice());

    }
}
