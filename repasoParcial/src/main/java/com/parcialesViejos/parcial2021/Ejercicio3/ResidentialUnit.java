package com.parcialesViejos.parcial2021.Ejercicio3;

public class ResidentialUnit extends FunctionalUnit {

  private int rooms;
  private ResidentialExpenses rExpenses;

  public ResidentialUnit(String name, int m2, int rooms, ResidentialExpenses rExpenses, Expenses globalExpenses) {
    super(name, m2, globalExpenses);
    this.rooms = rooms;
    this.rExpenses = rExpenses;
  }

  private void calculateExpenses() {
    total = super.getGlobalExpenses() + rExpenses.calculateExpenses(rooms);
  }

  @Override
  public String toString() {
    calculateExpenses();
    return super.toString("Residential");
  }

}
