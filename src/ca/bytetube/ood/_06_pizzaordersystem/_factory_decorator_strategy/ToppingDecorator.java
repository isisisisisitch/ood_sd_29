package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public Size getSize() {
        return pizza.getSize();
    }
}
