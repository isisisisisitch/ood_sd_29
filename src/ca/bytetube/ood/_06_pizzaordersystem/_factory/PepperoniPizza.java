package ca.bytetube.ood._06_pizzaordersystem._factory;

public class PepperoniPizza extends Pizza {


    public PepperoniPizza(Size size) {
        super(size);
        this.name = "Pepperoni Pizza";
    }

    @Override
    public double getBasePrice() {
        switch (size) {
            case SMALL -> {
                return 10.99;
            }
            case MEDIUM -> {
                return 11.99;
            }
            case LARGE -> {
                return 12.99;
            }
            default -> {
                return 0;
            }
        }

    }
}
