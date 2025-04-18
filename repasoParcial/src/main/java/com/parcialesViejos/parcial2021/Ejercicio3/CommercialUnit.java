package com.parcialesViejos.parcial2021.Ejercicio3;

public class CommercialUnit extends FunctionalUnit {

  public CommercialUnit(String name, int m2, CommercialExpenses cExpenses, Expenses expenses) {
    super(name, m2, expenses);
    total = cExpenses.calculateExpenses(getGlobalExpenses());
  }

  @Override
  public String toString() {
    return super.toString("Comercial");
  }
  
}
