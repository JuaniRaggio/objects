package com.parcialesViejos.parcial20222C.Loan;

import java.time.LocalDate;

public class LoanType1 extends Loan {

  private int lastPayInstallment;
  
  public LoanType1(Destination dest, int price, int installmentsDesired, LocalDate date) {
    super(dest, installmentsDesired, price, date);
  }

  @Override
  public boolean canPay(int payInstallment, LocalDate date) {
    return super.canPay(payInstallment, date) && payInstallment != lastPayInstallment - 1;
  }

}
