package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public class CheesePizza extends BasePizza {
    public CheesePizza(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Cheese Pizza (" + size + ")";
    }

    @Override
    public double getCost() {
        return switch (size) {
            case SMALL -> 8.99;
            case MEDIUM -> 10.99;
            case LARGE -> 12.99;
        };
    }
}

