package ca.bytetube.ood._08_shoppingcart.v2_chain;

public abstract class AbstractDiscountHandler implements DiscountHandler {
    private DiscountHandler next;

    @Override
    public void setNext(DiscountHandler next) {
        this.next = next;
    }

    @Override
    public void handle(PricingContext context) {
        apply(context);
//        if (shouldContinue(context)) {
            if (next != null) {
                next.handle(context);
            }
//        }

    }

    protected abstract void apply(PricingContext context);
}



