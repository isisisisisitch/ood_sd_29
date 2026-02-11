package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public class MushroomDecorator extends ToppingDecorator {
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}
