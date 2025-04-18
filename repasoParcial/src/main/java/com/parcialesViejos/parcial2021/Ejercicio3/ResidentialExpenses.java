package com.parcialesViejos.parcial2021.Ejercicio3;

public class ResidentialExpenses implements ExpensesContract {

  // Cargo extra por ambiente sobre total para las U.F. residenciales
  private double residentialRoomExpense = 200.0;

  public double getExpenses() {
    return residentialRoomExpense;
  }

  public void setExpenses(double residentialRoomExpense) {
    this.residentialRoomExpense = residentialRoomExpense;
  }

  public double calculateExpenses(double rooms) {
    return residentialRoomExpense * rooms;
  }

}
