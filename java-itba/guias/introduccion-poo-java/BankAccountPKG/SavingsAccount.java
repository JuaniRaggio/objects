package BankAccountPKG;

public class SavingsAccount extends BankAccount {

  public SavingsAccount(int id) {
    this.id = id;
    this.balance = 0;
  }

  protected boolean canExtract(double amount) {
    validate_amount(amount, super.error_extraction_String);
    // If the first one is greater, returns 1
    return Double.compare(balance - amount, 0) == 1;
  }

  public void extract(double amount) {
    if (canExtract(amount)) this.balance -= amount;
    else {
      throw new RuntimeException("No cuenta con los fondos necesarios");
    }
  }

  public void deposit(double amount) throws IllegalArgumentException {
    validate_amount(amount, super.error_deposit_String);
    this.balance += amount;
  }

  public double getBalance() {
    return balance;
  }

}
