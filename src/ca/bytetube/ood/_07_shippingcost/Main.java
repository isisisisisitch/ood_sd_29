package ca.bytetube.ood._07_shippingcost;

public class Main {
    public static void main(String[] args) {

        Member member = new Member("M001","Dal",MemberShipLevel.GOLD);
        Package p1 = new BasePackage(Size.LARGE,DeliverySpeed.SAME_DAY);
        p1 = new SignatureRequiredDecorator(p1);
        p1 = new FragilePackingDecorator(p1);

        Package p2 = new BasePackage(Size.MEDIUM,DeliverySpeed.NEXT_DAY);
        p2 = new SignatureRequiredDecorator(p2);
        p2 = new GiftWrapDecorator(p2);

        Order order = new Order(member);
        order.addPackage(p1);
        order.addPackage(p2);
        order.printOrderDetails();


    }
}
