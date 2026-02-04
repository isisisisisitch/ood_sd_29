package ca.bytetube.ood._04_banksystem;

public class Deposit extends Transaction {
    private int amount;

    public Deposit(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getTransactionDesc() {
        return "teller: " + tellerId + " deposited " + amount + " to account " + customerId;
    }
}
