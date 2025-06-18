package com.parcialesViejos.parcial20222C.StockProduct;

public class StockProduct {

  private final String product;
  private int stock;

  public StockProduct(String product, int stock) {
    if (stock < 0) {
      throw new java.lang.IllegalArgumentException("Stock cannot be negative.");
    }
    this.product = product;
    this.stock = stock;
  }

  public String getProduct() {
    return product;
  }

  public int getStock() {
    return stock;
  }

  public void reduceStock() {
    if (getStock() == 0) {
      throw new java.lang.IllegalStateException("No stock to reduce.");
    }
    stock--;
  }

  @Override
  public String toString() {
    return String.format("Product %s has %s units", getProduct(), getStock());
  }

}
