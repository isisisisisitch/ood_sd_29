package ca.bytetube.ood._07_shippingcost;

public abstract class ItemOptionDecorator implements Package {
    Package pack;

    public ItemOptionDecorator(Package pack) {
        this.pack = pack;
    }

    @Override
    public Size getSize() {
        return pack.getSize();
    }
}
