package ca.bytetube.ood._07_shippingcost;

public enum MemberShipLevel {
    NONE(0.0), BRONZE(5.0), SILVER(10.0), GOLD(15.0);

    private final double multiplier;

    MemberShipLevel(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return (100.0 - multiplier) / 100.0;
    }
}
