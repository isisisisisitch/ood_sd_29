package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public abstract class BasePizza implements Pizza {
    protected Size size;

    public BasePizza(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }
}
