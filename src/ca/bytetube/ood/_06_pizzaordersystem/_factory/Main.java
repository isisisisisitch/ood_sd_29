package ca.bytetube.ood._06_pizzaordersystem._factory;

public class Main {

    public static void main(String[] args) {
        Pizza cheesePizza = PizzaFactory.createPizza("cheese", Size.LARGE);//12.99
        cheesePizza.addTopping(new Topping("extra cheese", 1.50));//1.5
        cheesePizza.addTopping(new Topping("Mushroom", 1.00));//1
        Order order = new Order();
        order.addPizza(cheesePizza);

        Pizza peperoniPizza = PizzaFactory.createPizza("Pepperoni", Size.MEDIUM);//11.99
        peperoniPizza.addTopping(new Topping("Olive", 0.75));//0.75
        order.addPizza(peperoniPizza);

        System.out.println(order.getTotalPrice());//28.23

    }
}
