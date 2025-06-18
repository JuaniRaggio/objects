package com.parcialesViejos.parcial2021.Ejercicio3;

public abstract class FunctionalUnit {

  private Double m2Mult;
  private String name;
  private int m2;
  protected double total = 0;

  protected FunctionalUnit(String name, int m2, Double globalExpenses) {
    this.name = name;
    this.m2 = m2;
    this.m2Mult = globalExpenses;
  }

  protected double getGlobalExpenses() {
    return m2 * m2Mult;
  }

  @Override
  public String toString() {
    return "U.F. %s ( %d m2 ) : $%g".formatted(name, m2, total);
  }
  
}
