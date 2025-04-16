package com.parcialesViejos.parcial2021.Ejercicio1;

import java.util.Arrays;
import java.util.Comparator;

public class InventoryTest {

  public void mainTest() {
    Item item1 = new Item("A", 100.0);
    Item item2 = new Item("B1", 200.0);
    Item item3 = new Item("B2", 200.0);
    Item[] items = new Item[]{item3, item1, item2};
    Inventory inventory = new Inventory(items);
    // Orden natural: ascendente por precio y desempata alfabéticamente por nombre
    Item[] itemsByPriceAsc = inventory.getItems();
    System.out.println(Arrays.toString(itemsByPriceAsc));
    System.out.println("----------");
    // Orden: descendente por precio y desempata alfabéticamente por nombre
    Item[] itemsByPriceDesc = inventory.getItems((a, b) -> {
      int cmpPrice = Item.compareItemPrices(b, a), cmpName;
      if (cmpPrice == 0) {
        cmpName = Item.compareItemNames(a, b);
        if (cmpName == 0) {
          return 0;
        }
        return cmpName;
      }
      return cmpPrice;
    });
    System.out.println(Arrays.toString(itemsByPriceDesc));
    System.out.println("----------");
    // Orden: alfabético por nombre y desempata ascendente por precio
    Item[] itemsByNameAsc = inventory.getItems((a, b) -> {
      int cmpPrice, cmpName = Item.compareItemNames(a, b);
      if (cmpName == 0) {
        cmpPrice = Item.compareItemPrices(a, b);
        if (cmpPrice == 0) {
          return 0;
        }
        return cmpPrice;
      }
      return cmpName;
    });
    System.out.println(Arrays.toString(itemsByNameAsc));
    System.out.println("----------");
  }

}
