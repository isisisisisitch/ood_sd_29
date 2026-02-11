package ca.bytetube.ood._06_pizzaordersystem._factory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Pizza> pizzas;
    private double price;
    private int orderCounter;

    public Order() {
        pizzas = new ArrayList<>();
        this.id = ++orderCounter;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public double getTotalPrice() {
        return pizzas.stream().mapToDouble(Pizza::calculateTotalPrice).sum();
//        double totalPrice = 0;
//        for (Pizza pizza : pizzas) {
//            totalPrice += pizza.calculateTotalPrice();
//        }
//
//        return totalPrice;
    }

}
