package ca.bytetube.ood._06_pizzaordersystem._factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected Size size;
    List<Topping> toppings;

    public Pizza(Size size) {
        this.size = size;
        this.toppings = new ArrayList<>();
    }


    public abstract double getBasePrice();

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculateTotalPrice() {
        double total = getBasePrice();
        for (Topping t : toppings) {
            total += t.getPrice();
        }

        return total;
    }

}
