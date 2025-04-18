package com.parcialesViejos.parcial2021.Ejercicio3;

public class Building {

  private Expenses buildingExpenses;

  private CommercialExpenses cExpenses;

  private ResidentialExpenses rExpenses;

  public Building() {
    buildingExpenses = new Expenses();
    cExpenses = new CommercialExpenses();
    rExpenses = new ResidentialExpenses();
  }

  public FunctionalUnit newResidentialFunctionalUnit(String name, int m2, int rooms) {
    return new ResidentialUnit(name, m2, rooms, rExpenses, buildingExpenses);
  }

  public FunctionalUnit newCommercialFunctionalUnit(String name, int m2, int rooms) {
    return new CommercialUnit(name, m2, cExpenses, buildingExpenses);
  }

  public double getM2Expense() {
    return buildingExpenses.getM2Expense();
  }

  public void setM2Expense(double m2Expense) {
    buildingExpenses.setM2Expense(m2Expense);
  }

  public double getCommercialMult() {
    return cExpenses.getExpenses();
  }

  public void setCommercialMult(double commercialMult) {
    cExpenses.setExpenses(commercialMult);
  }

  public double getResidentialRoomExpense() {
    return rExpenses.getExpenses();
  }

  public void setResidentialRoomExpense(double residentialRoomExpense) {
    rExpenses.setExpenses(residentialRoomExpense);
  }

}
