package com.parcialesViejos.parcial20232C.ReportCollection;

import java.util.Arrays;

public class Reports<R> implements ReportCollection<R> {

  private final int BLOCK_SIZE = 8;
  private int addedElements = 0;
  private R[] collection;

  private void resize() {
    collection = Arrays.copyOf(collection, addedElements + BLOCK_SIZE);
  }

  protected int getAddedElements() { return addedElements; }

  @SuppressWarnings("unchecked")
  public Reports() {
    collection = (R[]) new Object[BLOCK_SIZE];
  }

  public void add(R report) {
    if (addedElements == collection.length) {
      resize();
    }
    collection[addedElements++] = report;
  }

  public R get(int index) {
    if (index >= addedElements || index < 0) {
      throw new IllegalArgumentException();
    }
    return collection[index];
  }

  public R[] reports() {
    return collection;
  }
  
}
