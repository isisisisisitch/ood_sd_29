package ca.bytetube.ood._06_pizzaordersystem._factory_decorator_strategy;

public class MembershipDiscount implements DiscountStrategy {
    private final Member member;

    public MembershipDiscount(Member member) {
        this.member = member;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * member.getLevel().getDiscountMultiplier();
    }

    @Override
    public String getDescription() {
        return "Membership " + member.getLevel() + " Discount";
    }
}

