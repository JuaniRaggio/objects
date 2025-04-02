package BankAccountPKG;

import java.lang.String;

abstract class BankAccount {

  protected int id;

  protected double balance;

  protected final String error_deposit_String = "Error: Trying to deposit a negative amount. Might want to use extract method";

  protected final String error_extraction_String = "Error: Trying to extract a negative amount. Might want to use deposit method";

  protected void validate_amount(double amount, String msg) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException(msg);
    }
  }

  public String toString() {
    return String.format("Cuenta: %d con saldo %g", id, balance);
  }

  abstract public void deposit(double amount);

  abstract public void extract(double amount);

  abstract protected boolean canExtract(double amount);

  abstract public double getBalance();

}
