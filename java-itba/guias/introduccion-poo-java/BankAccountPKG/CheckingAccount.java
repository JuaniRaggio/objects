package BankAccountPKG;

public class CheckingAccount extends BankAccount {

  private double overdraft;

  public CheckingAccount(int id, double overdraft) {
    this.overdraft = overdraft;
    this.id = id;
    this.balance = 0;
  }

  public void deposit(double amount) throws IllegalArgumentException {
    validate_amount(amount, super.error_deposit_String);
    this.balance += amount;
  }

  public void extract(double amount) {
    validate_amount(amount, super.error_extraction_String);
    if (canExtract(amount)) this.balance -= amount;
  }

  protected boolean canExtract(double amount) {
    return Double.compare(overdraft, this.balance - amount) == 1;
  }

  public double getBalance() {
    return this.balance;
  }

}
