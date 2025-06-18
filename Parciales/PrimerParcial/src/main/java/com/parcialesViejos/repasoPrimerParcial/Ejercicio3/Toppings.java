package com.parcialesViejos.repasoPrimerParcial.Ejercicio3;

public enum Toppings {

  EXTRAQUESO("Extra queso", 20), TOMATE("Tomate", 30), CEBOLLA("Cebolla", 10);

  private String description;
  private double price;

  private Toppings(String description, double price) {
    this.description = description;
    this.price = price;
  }

  @Override
  public String toString() {
    return "con %s".formatted(description);
  }

  public double getPrice() {
      return price;
  }
  
}
