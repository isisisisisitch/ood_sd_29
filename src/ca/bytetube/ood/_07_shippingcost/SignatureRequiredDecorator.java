package ca.bytetube.ood._07_shippingcost;

public class SignatureRequiredDecorator extends ItemOptionDecorator {
    public SignatureRequiredDecorator(Package pack) {
        super(pack);
    }

    @Override
    public String getDescription() {
        return pack.getDescription() + ", add signature require";
    }

    @Override
    public double getCost() {
        //add-on cost = ItemOption * BoxSizeMultiplier
        return pack.getCost() + 7.00 * pack.getSize().getMultiplier();
    }
}
