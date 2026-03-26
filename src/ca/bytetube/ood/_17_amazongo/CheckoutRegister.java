package ca.bytetube.ood._17_amazongo;

public class CheckoutRegister {
    public Price total(Session session) {
        return null;
    }

    public Order buildOrder(Session s) {
        Order order = new Order(s.getId(), "O-" + System.nanoTime());
        for (var e : s.getBasket().view().entrySet()) {
            order.add(e.getKey(), e.getValue());
        }

        return order;
    }

    public Receipt buildReceipt(Order order) {
        Receipt receipt = new Receipt(order.getId());
        for (var e : order.getItems().entrySet()) {
            receipt.add(e.getKey(), e.getValue());
        }

        return receipt;
    }

    public PaymentResult pay(Order order, PaymentMethod method) {
        Receipt receipt = buildReceipt(order);
        Price total = receipt.getTotal();
        PaymentResult auth = method.authorize(total);
        if (auth.getStatus() != PaymentStatus.AUTHORIZED) return auth;
        return method.capture(auth.getAuthorizationId(), total);
    }
}
