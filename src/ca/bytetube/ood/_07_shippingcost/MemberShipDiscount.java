package ca.bytetube.ood._07_shippingcost;

public class MemberShipDiscount {
    private Member member;

    public MemberShipDiscount(Member member) {
        this.member = member;
    }

    public double applyDiscount(double originalPrice){
        return member.getLevel().getMultiplier() * originalPrice;
    }


}
