package ca.bytetube.ood._17_amazongo;

public class CardOnFile implements PaymentMethod {
    String maskedPan;

    public CardOnFile(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    @Override
    public PaymentResult authorize(Price total) {
        if (total.getAmount() < 0) {
            return new PaymentResult(PaymentStatus.DECLINED, null, null, "Negative amount");
        }
        String authId = "AUTH-" + System.nanoTime();

        return new PaymentResult(PaymentStatus.AUTHORIZED, authId, null, "AUTHORIZED");
    }

    @Override
    public PaymentResult capture(String authorizeId, Price total) {
        String capId = "CAP-" + System.nanoTime();

        return new PaymentResult(PaymentStatus.CAPTURED, authorizeId, capId, "CAPTURED");
    }
}
