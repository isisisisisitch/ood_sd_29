package ca.bytetube.ood._07_shippingcost;

public class FragilePackingDecorator extends ItemOptionDecorator {
    public FragilePackingDecorator(Package pack) {
        super(pack);
    }

    @Override
    public String getDescription() {
        return pack.getDescription() + ", add fragile packing";
    }

    @Override
    public double getCost() {
        //add-on cost = ItemOption * BoxSizeMultiplier
        return pack.getCost() + 5.00 * pack.getSize().getMultiplier();
    }
}
