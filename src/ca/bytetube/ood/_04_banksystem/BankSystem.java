package ca.bytetube.ood._04_banksystem;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public BankSystem() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public int openAccount(int tellerId, String name) {
        //add account
        int customerId = accounts.size();
        BankAccount account = new BankAccount(customerId, name, 0);
        accounts.add(account);

        //log transaction
        Transaction transaction = new OpenAccount(customerId, tellerId);
        transactions.add(transaction);

        return customerId;
    }

    public int deposit(int tellerId, int customerId, int amount) {
        BankAccount account = accounts.get(customerId);
        account.deposit(amount);

        //log transaction
        Transaction transaction = new Deposit(customerId, tellerId, amount);
        transactions.add(transaction);

        return account.getBalance();
    }

    public int withdraw(int tellerId, int customerId, int amount) {
        BankAccount account = accounts.get(customerId);
        account.withdraw(amount);

        //log transaction
        Transaction transaction = new Withdraw(customerId, tellerId, amount);
        transactions.add(transaction);

        return account.getBalance();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
