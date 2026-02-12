package ca.bytetube.ood._07_shippingcost;

public class GiftWrapDecorator extends ItemOptionDecorator {

    public GiftWrapDecorator(Package pack) {
        super(pack);
    }

    @Override
    public String getDescription() {
        return pack.getDescription() + ", add gift wrap";
    }

    @Override
    public double getCost() {
        //add-on cost = ItemOption * BoxSizeMultiplier
        return pack.getCost() + 3.00 * pack.getSize().getMultiplier();
    }
}
