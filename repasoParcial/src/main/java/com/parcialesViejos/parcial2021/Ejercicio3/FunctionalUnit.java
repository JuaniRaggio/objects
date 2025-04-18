package com.parcialesViejos.parcial2021.Ejercicio3;

public abstract class FunctionalUnit {

  private Expenses globalExpenses;
  private String name;
  private int m2;
  protected double total = 0;

  protected FunctionalUnit(String name, int m2, Expenses globalExpenses) {
    this.name = name;
    this.m2 = m2;
    this.globalExpenses = globalExpenses;
  }

  protected double getGlobalExpenses() {
    return m2 * globalExpenses.getM2Expense();
  }

  protected String toString(String type) {
    return "%s: U.F. %s ( %d m2 ) : $%g".formatted(type, name, m2, total);
  }
  
}
