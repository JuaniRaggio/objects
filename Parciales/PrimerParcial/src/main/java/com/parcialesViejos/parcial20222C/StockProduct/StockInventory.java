package com.parcialesViejos.parcial20222C.StockProduct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StockInventory implements Iterable<StockResult> {

  private Predicate<Integer> warningCondition = (stock) -> stock <= 1;
  private int elementsInStock = 0;
  private final int BLOCK = 8;
  private StockProduct[] inventory = new StockProduct[BLOCK];

  private void resize(int newSize) {
    inventory = Arrays.copyOf(inventory, newSize);
  }

  public void add(String product, int stock) {
    StockProduct toAdd = new StockProduct(product, stock);
    if (elementsInStock == inventory.length) {
      resize(inventory.length + BLOCK);
    }
    inventory[elementsInStock++] = toAdd;
  }

  public void reduceStock(String product) {
    for (int i = 0; i < elementsInStock; ++i) {
      if (product.compareTo(inventory[i].getProduct()) == 0) {
        inventory[i].reduceStock();
        return;
      }
    }
  }

  public void setMinimumStock(Predicate<Integer> warningCondition) {
    this.warningCondition = warningCondition;
  }

  public Iterator<StockResult> iterator() {
    return new Iterator<StockResult>() {

      private Predicate<Integer> conditionToWarn = warningCondition;
      private int currentElement = 0;

      public boolean hasNext() {
        return currentElement < elementsInStock;
      }

      public StockResult next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return new StockResult(conditionToWarn, inventory[currentElement++]);
      }

    };
  }
  
}
