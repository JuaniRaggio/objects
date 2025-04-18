package com.parcialesViejos.parcial2021.Ejercicio3;

public class Building {

  private Expenses buildingExpenses;

  private CommercialExpenses commercialExpenses;

  private ResidentialExpenses residentialExpenses;

  public Building() {
    buildingExpenses = new Expenses();
    commercialExpenses = new CommercialExpenses();
    residentialExpenses = new ResidentialExpenses();
  }

  public FunctionalUnit newResidentialFunctionalUnit(String name, int m2, int rooms) {
    return new ResidentialUnit(name, m2, rooms, residentialExpenses, buildingExpenses);
  }

  public FunctionalUnit newCommercialFunctionalUnit(String name, int m2) {
    return new CommercialUnit(name, m2, commercialExpenses, buildingExpenses);
  }

  public double getM2Expense() {
    return buildingExpenses.getM2Expense();
  }

  public void setM2Expense(double m2Expense) {
    buildingExpenses.setM2Expense(m2Expense);
  }

  public double getCommercialMult() {
    return commercialExpenses.getExpenses();
  }

  public void setCommercialMult(double commercialMult) {
    commercialExpenses.setExpenses(commercialMult);
  }

  public double getResidentialRoomExpense() {
    return residentialExpenses.getExpenses();
  }

  public void setResidentialRoomExpense(double residentialRoomExpense) {
    residentialExpenses.setExpenses(residentialRoomExpense);
  }

}
