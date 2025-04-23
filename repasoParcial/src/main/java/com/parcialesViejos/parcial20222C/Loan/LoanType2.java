package com.parcialesViejos.parcial20222C.Loan;

import java.time.LocalDate;

public class LoanType2 extends LoanType1 {

  private LocalDate lastPayDate;
  
  public LoanType2(Destination dest, int price, int installmentsDesired, LocalDate date) {
    super(dest, installmentsDesired, price, date);
    lastPayDate = date;
  }

  @Override
  public boolean canPay(int payInstallment, LocalDate date) {
    return super.canPay(payInstallment, date) && date.isAfter(lastPayDate);
  }
  
}
