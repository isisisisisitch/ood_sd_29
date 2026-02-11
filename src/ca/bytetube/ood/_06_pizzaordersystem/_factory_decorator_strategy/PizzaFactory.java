package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public class PizzaFactory {
    public static Pizza createPizza(String type, Size size) {
        return switch (type.toLowerCase()) {
            case "cheese" -> new CheesePizza(size);
            case "pepperoni" -> new PepperoniPizza(size);
//            case "veggie" -> new VeggiePizza(size);
            default -> throw new IllegalArgumentException("Unknown pizza type: " + type);
        };
    }
}
