// No se puede modificar
public class PaymentDetail {
  private final int installment;
  private final double installmentAmount;
  public PaymentDetail(int installment, double installmentAmount) {
    this.installment = installment;
    this.installmentAmount = installmentAmount;
  }
  @Override
  public String toString() {
    return "$%.2f due for installment %d".formatted(installmentAmount, installment);
  }
}

// Hay 3 planes de pago
// En comun: Cantidad de cuotas + Bonificacion + Condicion para la bonificacion

// Validar cuotas, monotos y cantidad maxima de cuotas

public enum PaymentMethods {
  CAP12NOB(12) {
    @Override
    public double applyBono(double installmentAmount) { return installmentAmount; }

    @Override
    public boolean shouldApply(int installmentNumber) { return false; }
  },
  CAPB24(24), {
    private int limit = 3;

    @Override
    protected double apply(int installmentNumber, double installmentAmount) {
      return 0;
    }

    @Override
    public boolean shouldApply(int installmentNumber) { return installmentNumber <= limit; }
  },
  CAPB360(360) {
    @Override
    protected double apply(double installmentAmount) {
      return installmentAmount*0.5;
    }

    @Override
    public boolean shouldApply(int installmentNumber) { return installmentNumber % 2 == 0; }
  };

  private final int cap;

  private PaymentMethods(int cap) {
    this.cap = cap;
  }

  public int getCap() { return cap; }

  public void validateInstallment(int installmentsDesired) {
    if (installmentsDesired > cap || installmentsDesired < 0) {
      // Preguntar si es valido hacer esto
      throw new InvalidPaymentPlanException("Invalid payment plan");
    }
  }

  public double applyBono(int installmentNumber, double installmentAmount) {
    if (shouldApply(installmentNumber)) {
      return installmentAmount.apply();
    }
    return installmentAmount;
  }

  public abstract boolean shouldApply(int installmentNumber);

}

public class InvalidPaymentPlanException extends RuntimeException {}

public class PaymentPlan {

  private PaymentDetail[] payments;

  private final PaymentMethods method;

  private int iterator = 0;

  public static boolean validateAmount(double totalAmount) {
    if (totalAmount < 0)
      throw new IllegalArgumentException("Invalid totalAmount");
  }

  public PaymentPlan(PaymentMethods method, double totalAmount, int desiredPayments) {
    validateAmount(totalAmount);
    method.validateInstallment(desiredPayments);
    this.method = method;
    payments = new PaymentDetail[desiredPayments];
    fillPayments(totalAmount / desiredPayments);
  }

  private void fillPayments(double amounts) {
    for (int i = 0; i < payments.length; ++i) {
      payments[i] = method.applyBono(i, amounts);
    }
  }

  public boolean hasNext() {
    return iterator < payments.length;
  }

  public PaymentDetail peek() {
    if (!hasNext()) {
      throw new RuntimeException();
    }
    return payments[iterator];
  }

  public PaymentDetail next() {
    PaymentDetail returnValue = peek();
    iterator++;
    return returnValue;
  }

}

