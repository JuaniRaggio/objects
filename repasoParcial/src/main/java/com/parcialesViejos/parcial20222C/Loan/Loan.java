package com.parcialesViejos.parcial20222C.Loan;

import java.time.LocalDate;

public class Loan {

  private LocalDate date;
  private int installments;
  private long price;
  private final Destination dest;

  public Loan(Destination dest, int installmentsDesired, long price, LocalDate date) {
    if (!dest.verifysInstallments(installmentsDesired) || !dest.verifysPrice(price)) {
      throw new LoanException("Invalid Loan");
    }
    this.installments = installmentsDesired;
    this.price = price;
    this.dest = dest;
    this.date = date;
  }

  protected boolean canPay(int installment, LocalDate date) {
    return installments > 0 && date.isAfter(this.date);
  }

  private void validatePayment(int installment, LocalDate date) {
    if (canPay(installment, date)) {
      throw new LoanException("Cannot pay");
    }
  }

  public void pay(int installment, LocalDate date) {
    validatePayment(installment, date);
    System.out.println("Paying quota %d on date %s".formatted(installment, date));
  }
  
}
