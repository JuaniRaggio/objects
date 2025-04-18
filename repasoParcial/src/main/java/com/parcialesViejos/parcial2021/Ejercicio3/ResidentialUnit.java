package com.parcialesViejos.parcial2021.Ejercicio3;

public class ResidentialUnit extends FunctionalUnit {

  public ResidentialUnit(String name, int m2, int rooms, ResidentialExpenses rExpenses, Expenses globalExpenses) {
    super(name, m2, globalExpenses);
    total = rExpenses.calculateExpenses(rooms) + getGlobalExpenses();
  }

  @Override
  public String toString() {
    return super.toString("Residential");
  }

}
