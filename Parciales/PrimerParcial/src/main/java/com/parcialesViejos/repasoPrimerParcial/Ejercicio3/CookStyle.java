package com.parcialesViejos.repasoPrimerParcial.Ejercicio3;

public enum CookStyle {

  PARRILLA("a la parrilla", 150), HORNO("al horno", 100);

  private String description;
  private double price;

  private CookStyle(String description, double price) {
    this.description = description;
    this.price = price;
  }

  @Override
  public String toString() {
    return description;
  }

  public double getPrice() {
      return price;
  }

}
