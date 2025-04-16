package com.parcialesViejos.repasoPrimerParcial.Ejercicio3;

public class Pizza {

  private CookStyle cookStyle;
  private Toppings[] toppings;
  private double price;
  private String description;

  private void assignAttributes() {
    StringBuilder desc = new StringBuilder();
    desc.append(cookStyle.toString());
    price += cookStyle.getPrice();
    for (int i = 0; i < toppings.length; ++i) {
      desc.append(toppings[i].toString());
      price += toppings[i].getPrice();
    }
    description = desc.append(": %g".formatted(price)).toString();
  }

  public Pizza(CookStyle cookStyleRequested, Toppings[] toppingsRequested) {
    this.cookStyle = cookStyleRequested;
    this.toppings = toppingsRequested;
    assignAttributes();
  }

  public String getDescription() {
      return description;
  }

  @Override
  public String toString() {
    return getDescription();
  }

}
