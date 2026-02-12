package ca.bytetube.ood._07_shippingcost;

public class BasePackage implements Package {
    private Size size;
    private DeliverySpeed speed;

    public BasePackage(Size size, DeliverySpeed speed) {
        this.size = size;
        this.speed = speed;
    }

    @Override
    public String getDescription() {
        return "Package:(" + size + " ," + speed + ").";

    }

    @Override
    public double getCost() {
        //Base Price = DeliverySpeed * BoxSizeMultiplier
        return speed.getCost() * size.getMultiplier();
    }

    @Override
    public Size getSize() {
        return size;
    }
}
