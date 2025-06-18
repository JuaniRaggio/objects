package com.parcialesViejos.parcial20222C.Loan;

public enum Destination {

  PERSONAL(12, 50_000), VEHICLE(24, 300_000), HOME(360, 1_000_000);

  private int installmentsLimit;
  private long priceLimit;

  private Destination(int installmentsLimit, long priceLimit) {
    this. installmentsLimit = installmentsLimit;
    this.priceLimit = priceLimit;
  }

  // Esta bien que retorne un boolean o con que sea void y arroje un error esta ok?
  public boolean verifysInstallments(int installmentsDesired) {
    return Integer.compare(installmentsLimit, installmentsDesired) > 0;
  }

  public boolean verifysPrice(long price) {
    return Long.compare(priceLimit, price) > 0;
  }

}

