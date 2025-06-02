package com.collections.tp6.bankAccounts;

import java.util.HashSet;
import java.util.Set;

public class Bank {

  private Set<BankAccount> accounts = new HashSet<>();

  public boolean addAccount(BankAccount acc) {
    return accounts.add(acc);
  }

  public int accountSize() {
    return accounts.size();
  }

  public double totalAmount() {
    double accumulator = 0;
    for (BankAccount acc : accounts) {
      accumulator += acc.getBalance();
    }
    return accumulator;
  }

  public void removeAccount(BankAccount acc) {
    accounts.remove(acc);
  }

}
