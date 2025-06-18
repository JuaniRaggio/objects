package com.collections.tp6.bankAccounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BankTest {

  @Test
  public void bankTest() {
    Bank bank = new Bank();
    BankAccount c1 = new CheckingAccount(1234, 5000);
    BankAccount c2 = new CheckingAccount(3462, 5000);
    bank.addAccount(c1);
    bank.addAccount(c2);
    System.out.println(bank.accountSize());
    System.out.println(bank.totalAmount());
    c1.deposit(100);
    c2.deposit(200);
    bank.removeAccount(c2);
    System.out.println(bank.accountSize());
    System.out.println(bank.totalAmount());
  }

}
