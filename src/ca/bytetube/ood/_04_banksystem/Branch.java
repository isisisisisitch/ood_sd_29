package ca.bytetube.ood._04_banksystem;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String address;
    private List<BankTeller> tellers;
    private int cashOnHold;
    private BankSystem system;

    public Branch(String address, int cashOnHold, BankSystem system) {
        this.address = address;
        this.cashOnHold = cashOnHold;
        this.system = system;
        tellers = new ArrayList<>();
    }


    private BankTeller getAvailableTeller() {
        int index = (int) Math.round(Math.random() * (tellers.size() - 1));
        return tellers.get(index);
    }

    public int openAccount(String name) {
        if (tellers.isEmpty()) throw new RuntimeException("there is no available teller ,pls wait for a while");
        BankTeller teller = getAvailableTeller();
        return system.openAccount(teller.getId(), name);
    }

    public void deposit(int customerId, int amount) {
        if (tellers.isEmpty()) throw new RuntimeException("there is no available teller ,pls wait for a while");

        BankTeller teller = getAvailableTeller();

        system.deposit(teller.getId(), customerId, amount);
        cashOnHold += amount;
    }

    public void withdraw(int customerId, int amount) {
        if (tellers.isEmpty()) throw new RuntimeException("there is no available teller ,pls wait for a while");

        BankTeller teller = getAvailableTeller();

        system.withdraw(teller.getId(), customerId, amount);
        cashOnHold -= amount;
    }

    public int collectCash(double ratio) {
        int cashToCollect = (int) Math.round(cashOnHold * ratio);
        cashOnHold -= cashToCollect;
        return cashToCollect;
    }


    public void addTeller(BankTeller teller) {
        tellers.add(teller);
    }
}
