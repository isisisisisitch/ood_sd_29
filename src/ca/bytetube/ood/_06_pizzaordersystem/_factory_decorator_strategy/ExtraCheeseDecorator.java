package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public class ExtraCheeseDecorator extends ToppingDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}
