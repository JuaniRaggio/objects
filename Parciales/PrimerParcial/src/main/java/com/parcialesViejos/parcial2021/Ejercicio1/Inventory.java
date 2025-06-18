package com.parcialesViejos.parcial2021.Ejercicio1;

import java.util.Arrays;
import java.util.Comparator;

public class Inventory {

  private Item[] items;
  private int storedItems;

  public Inventory(Item[] items) {
    this.items = items;
  }

  public Item[] getItems() {
    return getItems(Comparator.naturalOrder());
  }

  public Item[] getItems(Comparator<Item> cmp) {
    Item[] retunValue = Arrays.copyOf(items, storedItems);
    Arrays.sort(retunValue, cmp);
    return retunValue;
  }

}
