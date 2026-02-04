package ca.bytetube.ood._04_banksystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Branch> branches;
    private BankSystem system;
    private int totalCash;

    public Bank(BankSystem system, int totalCash) {
        this.branches = new ArrayList<>();
        this.system = system;
        this.totalCash = totalCash;
    }

    public Branch addBranch(String address, int cashOnHold) {
        Branch branch = new Branch(address, cashOnHold, system);
        branches.add(branch);
        return branch;
    }

    public void collectCash(double ratio) {
        for (Branch branch : branches) {
            int collected = branch.collectCash(ratio);
            totalCash += collected;
        }

    }

    public void printTransactions() {
        for (Transaction transaction : system.getTransactions()) {
            System.out.println(transaction.getTransactionDesc());
        }
    }


}
