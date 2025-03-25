package BankAccountPKG;

public class BankAccountTester {

  public static void main (String[] args) {
    CheckingAccount myCheckingAccount = new CheckingAccount(1001, 50);
    myCheckingAccount.deposit(100.0);
    System.out.println(myCheckingAccount);
    myCheckingAccount.extract(150.0);
    System.out.println(myCheckingAccount);

    SavingsAccount mySavingsAccount = new SavingsAccount(1002);
    mySavingsAccount.deposit(100.0);
    System.out.println(mySavingsAccount);
    mySavingsAccount.extract(150.0); // No se realiza por falta de fondos
    System.out.println(mySavingsAccount);
  }

}
