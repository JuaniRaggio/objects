package com.parcialesViejos.parcial20241C.PaymentPlan;

public enum PaymentMethods {

  CAP12NOB(12) {

  public double apply(double installmentAmount) {
    return installmentAmount;
  }

  @Override
  public boolean shouldApply(int installmentNumber) {
    return false;
  }
  }, CAPB24(24) {

  private int limit = 3;

  protected double apply(int installmentNumber, double installmentAmount) {
    return 0;
  }

  @Override
  public boolean shouldApply(int installmentNumber) {
    return installmentNumber <= limit;
  }

  }, CAPB360(360) {

  protected double apply(double installmentAmount) {
    return installmentAmount * 0.5;
  }

  @Override
  public boolean shouldApply(int installmentNumber) {
    return installmentNumber % 2 == 0;
  }
  };

  private final int cap;

  private PaymentMethods(int cap) {
    this.cap = cap;
  }

  public int getCap() {
    return cap;
  }

  public void validateInstallment(int installmentsDesired) {
    if (installmentsDesired > cap || installmentsDesired < 0) {
      // Preguntar si es valido hacer esto
      throw new InvalidPaymentPlanException("Invalid payment plan");
    }
  }

  public double applyBono(int installmentNumber, double installmentAmount) {
    if (shouldApply(installmentNumber)) {
      return this.apply();
    }
    return installmentAmount;
  }

  public abstract boolean shouldApply(int installmentNumber);

}
