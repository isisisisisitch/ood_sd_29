package ca.bytetube.ood._07_shippingcost;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int orderCount;
    private List<Package> packages;
    private Member member;

    public Order(Member member) {
        orderId = ++orderCount;
        this.member = member;
        packages = new ArrayList<>();
    }

    public void addPackage(Package p) {
        packages.add(p);
    }

    public double getSubTotal() {
        return packages.stream().mapToDouble(Package::getCost).sum();
    }

    public double getTotalPrice() {
        double price = getSubTotal();
        if (member != null && member.getLevel() != MemberShipLevel.NONE) {
            MemberShipDiscount discount = new MemberShipDiscount(member);
            price = discount.applyDiscount(price);
        }

        return price;
    }

    public void printOrderDetails() {
        System.out.println("Order #" + orderId);

        if (member != null) {
            System.out.println("Member: " + member.getName() + " (" + member.getLevel() + ")");
        }

        System.out.println("\nItems:");
        packages.forEach(p ->
                System.out.println("- " + p.getDescription() +
                        " : $" + String.format("%.2f", p.getCost())));

        System.out.println("\nSubtotal: $" + String.format("%.2f", getSubTotal()));

        System.out.println("Final Total: $" + String.format("%.2f", getTotalPrice()));
    }


}
