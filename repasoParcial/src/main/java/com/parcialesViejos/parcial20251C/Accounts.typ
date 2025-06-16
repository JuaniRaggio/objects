= Ejercicio 1 - 3.5pts

== Una cuenta remunerada:
- Fecha de inicio
- Saldo inicial = 0

Se desea:
- Depositar fondos: Indicando *monto* y *fecha*.

  Error si: 
  + Fecha anterior a creacion
  + Monto menor a 0

- Extraer fondos: Indicando *monto* y *fecha*

  Error si:
    + Fecha anterior a creacion
    + Monto menor a 0

Notemos que los errores tienen la misma condicion $->$ una sola funcion que
como mucho reciba un mensaje para inicializar el error

Calculo de interes:
  - tasa anual 30% $-> 1 "dia" = "saldo" times 30/100 1/365$

Otros dos tipos de cuenta:

== Fecha de extraccion posterior a la ultima extraccion (guarda la ultima)

== Monto minimo

- Extiende de *Fecha de extraccion* ya que nos piden lo mismo para la fecha

- El monto minimo de ingreso es 100k

- Para el calculo de interes, el Saldo maximo es 1M 
(no es el limite de la cuenta) sino que es el numero con el que se calcularia
el interes en caso de que se supere

= Test

#table(columns : 1)[
```java
public static void main(String[] args) {
  // Ejemplo de uso de la clase java.time.MonthDay y java.time.Month
  MonthDay today = MonthDay.of(Month.APRIL, 24);
  System.out.println(today.isAfter(MonthDay.of(Month.MARCH, 1))); // true
  System.out.println(today.isBefore(MonthDay.of(Month.MAY, 1))); // true
  // Se instancia una cuenta remunerada el 15/01 donde se verifica que
  // - los montos de depósito y extracción son positivos
  // - las fechas de depósito y extracción no son anteriores a la fecha de creación
  // - se paga interés por el TOTAL del saldo
  .................... acc1 = new ....................................................................................................;
  // Se deposita un millón $1000000 en la cuenta remunerada
  acc1.depositFunds(1_000_000, MonthDay.of(Month.JANUARY, 18));
  acc1.depositFunds(50_000, MonthDay.of(Month.JANUARY, 16));
  System.out.printf("$%.2f\n", acc1.getBalance()); // $1050000,00
  // Se paga el interés por 3 días con TNA = 30% lo que es 0,3
  // Pago Día 1: $1050000,00 * 0,3 * (1,0 / 365) = $863,01
  // Pago Día 2: $1050863,01 * 0,3 * (1,0 / 365) = $863,72
  // Pago Día 3: $1051726,7
  acc1.interestPayment(3);

  System.out.printf("$%.2f\n", acc1.getBalance()); // $1052591,17
  // Se realiza una extracción de $500000
  acc1.withdrawFunds(500_000, MonthDay.of(Month.JANUARY, 20));
  System.out.printf("$%.2f\n", acc1.getBalance()); // $552591,17
  acc1.withdrawFunds(100_000, MonthDay.of(Month.JANUARY, 15));
  System.out.printf("$%.2f\n", acc1.getBalance()); // $452591,17
  // Se instancia una cuenta remunerada el 15/02 donde se verifica que
  // - los montos de depósito y extracción son positivos
  // - las fechas de depósito y extracción no son anteriores a la fecha de creación
  // y no se pueden realizar una extracción con una fecha anterior a la última extracción
  // (o anterior a la fecha de creación si es que todavía no se hizo ninguna extracción)
  // - se paga interés por el TOTAL del saldo
  .................... acc2 = new ....................................................................................................;
  acc2.depositFunds(1_000_000, MonthDay.of(Month.FEBRUARY, 18));
  acc2.depositFunds(50_000, MonthDay.of(Month.FEBRUARY, 16));
  System.out.printf("$%.2f\n", acc2.getBalance()); // $1050000,00
  acc2.interestPayment(3);
  System.out.printf("$%.2f\n", acc2.getBalance()); // $1052591,17
  acc2.withdrawFunds(500_000, MonthDay.of(Month.FEBRUARY, 20));
  System.out.printf("$%.2f\n", acc2.getBalance()); // $552591,17
  try {
    // Falla porque la fecha de extracción debe ser posterior al 20/02
    acc2.withdrawFunds(100_000, MonthDay.of(Month.FEBRUARY, 15));
  } catch (Exception ex) {
    System.out.println("Error"); // Error
  }
  System.out.printf("$%.2f\n", acc2.getBalance()); // $552591,17
  acc2.withdrawFunds(100_000, MonthDay.of(Month.FEBRUARY, 21));
  System.out.printf("$%.2f\n", acc2.getBalance()); // $452591,17
  // Se instancia una cuenta remunerada el 15/03 donde se verifica que
  // - los montos de depósito y extracción son positivos
  // y el monto de depósito mínimo es de cien mil pesos $100000,00
  // - las fechas de depósito y extracción no son anteriores a la fecha de creación
  // y no se pueden realizar una extracción con una fecha anterior a la última extracción
  // (o anterior a la fecha de creación si es que todavía no se hizo ninguna extracción)
  // - se paga interés SOLO HASTA 1 millón $1000000,00 del saldo
  .................... acc3 = new ....................................................................................................;
  acc3.depositFunds(1_000_000, MonthDay.of(Month.MARCH, 18));
  try {
    // Falla porque el monto de depósito debe ser mayor o igual a cien mil 100000
    acc3.depositFunds(50_000, MonthDay.of(Month.MARCH, 16));
  } catch (Exception ex) {
    System.out.println("Error"); // Error
  }
  System.out.printf("$%.2f\n", acc3.getBalance()); // $1000000,00
  acc3.depositFunds(500_000, MonthDay.of(Month.MARCH, 16));
  System.out.printf("$%.2f\n", acc3.getBalance()); // $1500000,00
  // Se paga el interés por 3 días con TNA = 30% lo que es 0,3
  // Pago Día 1: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
  // Pago Día 2: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
  // Pago Día 3: $1000000,00 * 0,3 * (1,0 / 365) = $821,91
  acc3.interestPayment(3);
  System.out.printf("$%.2f\n", acc3.getBalance()); // $1502465,75
  acc3.withdrawFunds(500_000, MonthDay.of(Month.MARCH, 20));
  System.out.printf("$%.2f\n", acc3.getBalance()); // $1002465,75
  acc3.withdrawFunds(100_000, MonthDay.of(Month.MARCH, 21));
  System.out.printf("$%.2f\n", acc3.getBalance()); // $902465,75
}
```
]


= Solucion

```java

public class Account {

  protected MonthDay creationDate;
  private double balance = 0.0;
  private static final double TNA = 0.3;

  private void canOperate(double amount, MonthDay depositDate) {
    if (creationDate.isAfter(depositDate) || Double.compare(amount, 0.0))
      throw new IllegalArgumentException();
  }

  public Account(MonthDay creationDate) {
    this.creationDate = creationDate;
  }

  public void depositFunds(double amount, MonthDay depositDate) {
    canOperate(amount, depositDate);
    balance += amount;
  }

  public void withdrawFunds(double amount, MonthDay withdrawDate) {
    canOperate(amount, withdrawDate);
    balance -= amount;
  }

  public double getBalance() {
    return balance;
  }

  private double getBalanceForInterest() {
    return balance;
  }

  public void interestPayment(int days) {
    if (days < 0)
      throw new IllegalArgumentException();
    for (int i = 0; i < days; ++i) {
      balance += getBalanceForInterest() * TNA * (1/365);
    }
  }

}

public class DateCheckAccount extends Account {

  protected MonthDay lastWithdraw = null;

  public void withdrawFunds(double amount, MonthDay withdrawDate) {
    canWithdraw(amount, withdrawDate)
    super.withdrawFunds(amount, withdrawDate);
    lastWithdraw = withdrawDate;
  }

  private void canWithdraw(double amount, MonthDay withdrawDate) {
    if (lastWithdraw != null && lastWithdraw.isAfter(withdrawDate))
      throw new IllegalArgumentException();
  }

}

public class LimitedInterestAccount extends DateCheckAccount {

  private static final double LIMIT = 1_000_000;
  private static final double DEPOSIT_MINIMUM = 100_000;

  private void canDeposit(double amount) {
    if (Double.comapre(amount, DEPOSIT_MINIMUM))
      throw new IllegalArgumentException();
  }

  public void depositFunds(double amount, MonthDay depositDate) {
    canDeposit(amount);
    super.depositFunds(amount, depositDate);
  }

  protected double getBalanceForInterest() {
    return Math.min(getBalance(), LIMIT);
  }

}

```

