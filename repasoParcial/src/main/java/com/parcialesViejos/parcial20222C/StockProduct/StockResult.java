package com.parcialesViejos.parcial20222C.StockProduct;

import java.util.function.Predicate;

public class StockResult {

  private StockProduct product;
  private Predicate<Integer> warningCondition;

  public StockResult(Predicate<Integer> warningCondition, StockProduct product) {
    this.product = product;
    this.warningCondition = warningCondition;
  }

  @Override
  public String toString() {
    return "Product %s has %d units <> %s".formatted(product.getProduct(), product.getStock(),
        warningCondition.test(product.getStock()) ? "Low Stock!" : "Stock OK");
  }

}
