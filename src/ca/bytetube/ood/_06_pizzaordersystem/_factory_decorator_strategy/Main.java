package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Member member = new Member("M001", "Dal", MembershipLevel.GOLD);
        Order order = new Order(member);

        // Create the first pizza using the factory and add toppings
        Pizza pizza1 = PizzaFactory.createPizza("cheese", Size.LARGE);//12.99
        pizza1 = new ExtraCheeseDecorator(pizza1);//1.50
        pizza1 = new MushroomDecorator(pizza1);// 1.00
        order.addPizza(pizza1);

        // Create the second pizza using the factory
        Pizza pizza2 = PizzaFactory.createPizza("pepperoni", Size.MEDIUM);//11.99
        order.addPizza(pizza2);//27.48

        // Create a coupon
        Coupon coupon = new Coupon("SAVE10", 10, true, LocalDate.now().plusDays(30));
        CouponManager couponManager = new CouponManager();
        couponManager.addCoupon(coupon);//24.732

        // Validate and apply the coupon
        couponManager.validateCoupon("SAVE10")
                .ifPresent(validCoupon -> order.addDiscount(new CouponDiscount(validCoupon)));

        order.printOrderDetails();//21.02
    }
}
