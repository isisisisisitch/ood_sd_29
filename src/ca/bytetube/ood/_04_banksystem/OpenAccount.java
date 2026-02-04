package ca.bytetube.ood._04_banksystem;

public class OpenAccount extends Transaction {

    public OpenAccount(int customerId, int tellerId) {
        super(customerId, tellerId);
    }

    @Override
    public String getTransactionDesc() {
        return "teller: " + tellerId + " opened account for " + customerId;
    }
}
