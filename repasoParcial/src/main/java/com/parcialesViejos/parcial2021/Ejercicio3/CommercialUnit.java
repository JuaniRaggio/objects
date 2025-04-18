package com.parcialesViejos.parcial2021.Ejercicio3;

public class CommercialUnit extends FunctionalUnit {

  private CommercialExpenses cExpenses;

  public CommercialUnit(String name, int m2, CommercialExpenses cExpenses, Expenses expenses) {
    super(name, m2, expenses);
    this.cExpenses = cExpenses;
  }

  private void calculateExpenses() {
    total = cExpenses.calculateExpenses(getGlobalExpenses());
  }

  @Override
  public String toString() {
    calculateExpenses();
    return super.toString("Comercial");
  }
  
}
