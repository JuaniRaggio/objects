package com.parcialesViejos.parcial2021.Ejercicio3;

public class CommercialExpenses implements ExpensesContract {

  // Multiplicador sobre total para las U.F. comerciales
  private double commercialMult = 3.0;

  public double getExpenses() {
    return commercialMult;
  }

  public void setExpenses(double commercialMult) {
    this.commercialMult = commercialMult;
  }

  public double calculateExpenses(double total) {
    return total * commercialMult;
  }

}
