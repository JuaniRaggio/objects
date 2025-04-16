package com.parcialesViejos.parcial2021.Ejercicio1;

public class Item implements Comparable<Item> {

  private final String name;
  private final double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return " %s >> $%g ".formatted(name, price);
  }

  public static int compareItemPrices(Item a, Item b) {
    return Double.compare(a.price, b.price);
  }

  public static int compareItemNames(Item a, Item b) {
    return a.name.compareTo(b.name);
  }

  @Override
  public int compareTo(Item other) {
    int cmpPrice = compareItemPrices(this, other), cmpName;
    if (cmpPrice == 0) {
      cmpName = compareItemNames(this, other);
      if (cmpName == 0) {
        return 0;
      }
      return cmpName;
    }
    return cmpPrice;
  }

}
