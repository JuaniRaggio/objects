package com.collections.tp6.bankAccounts;

import java.util.Objects;

public abstract class BankAccount {

  private final int id;
  protected double balance;

  protected BankAccount(int id) {
    this.id = id;
  }

  public double deposit(double amount) {
    return balance += amount;
  }

  public double extract(double amount) {
    if(canExtract(amount)) {
      return balance -= amount;
    }
    return balance;
  }

  protected abstract boolean canExtract(double amount);

  public double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "Cuenta %d con saldo %.2f".formatted(id, balance);
  }

  // El equals lo tengo que chequear porque nunca me acuerdo como es
  // lo voy a hacer como se me ocurre y despues lo corrijo
  public boolean equals(Object other) {
    return other instanceof BankAccount that && id == that.id;
  }

  public int hashCode() {
    return Objects.hash(id);
  }

}
