package ca.bytetube.ood._17_amazongo;

public interface PaymentMethod {
    PaymentResult authorize(Price total);

    PaymentResult capture(String authorizeId, Price total);
}
