package com.parcialesViejos.parcial2021.Ejercicio3;

public class ResidentialUnit extends FunctionalUnit {

  private int rooms;
  private Double rExpenses;

  public ResidentialUnit(String name, int m2, int rooms, Double rExpenses, Double globalExpenses) {
    super(name, m2, globalExpenses);
    this.rooms = rooms;
    this.rExpenses = rExpenses;
  }

  private void calculateExpenses() {
    total = super.getGlobalExpenses() + rExpenses * rooms;
  }

  @Override
  public String toString() {
    calculateExpenses();
    return "Residential: " + super.toString();
  }

}
