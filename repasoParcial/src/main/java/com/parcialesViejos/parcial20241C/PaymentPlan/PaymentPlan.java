package com.parcialesViejos.parcial20241C.PaymentPlan;

public class PaymentPlan {

  private final PaymentMethods method;

  private final double totalAmount;
  private final int totalPayments;
  private int paymentsLeft;

  public static boolean validateAmount(double totalAmount) {
    if (totalAmount < 0)
      throw new IllegalArgumentException("Invalid totalAmount");
    return true;
  }

  public PaymentPlan(PaymentMethods method, double totalAmount, int desiredPayments) {
    validateAmount(totalAmount);
    method.validateInstallment(desiredPayments);
    this.totalAmount = totalAmount;
    this.totalPayments = desiredPayments;
    this.method = method;
    paymentsLeft = totalPayments;
  }

  public boolean hasNext() {
    return paymentsLeft > 0;
  }

  private double getAmountToPay() { return totalAmount / totalPayments; }

  public PaymentDetail peek() {
    if (!hasNext()) {
      throw new RuntimeException();
    }
    return new PaymentDetail(totalPayments - paymentsLeft, method.apply(getAmountToPay()));
  }

  public PaymentDetail next() {
    PaymentDetail returnValue = peek();
    paymentsLeft--;
    return returnValue;
  }

}
