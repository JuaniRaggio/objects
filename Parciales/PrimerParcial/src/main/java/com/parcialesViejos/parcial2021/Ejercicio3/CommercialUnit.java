package com.parcialesViejos.parcial2021.Ejercicio3;

public class CommercialUnit extends FunctionalUnit {

  private Double cExpenses;

  public CommercialUnit(String name, int m2, Double cExpenses, Double expenses) {
    super(name, m2, expenses);
    this.cExpenses = cExpenses;
  }

  private void calculateExpenses() {
    total = cExpenses * getGlobalExpenses();
  }

  @Override
  public String toString() {
    calculateExpenses();
    return "Commercial: " + super.toString();
  }
  
}
