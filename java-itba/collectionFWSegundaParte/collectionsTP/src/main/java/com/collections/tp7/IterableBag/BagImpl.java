package com.collections.tp7.IterableBag;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BagImpl <T> implements Bag <T> {

  private Map<T, Integer> bag = new HashMap<>();

  public void add(T e) {
    bag.putIfAbsent(e, 0);
    bag.replace(e, bag.get(e), bag.get(e) + 1);
  }

  public void remove(T e) {
    if (bag.containsKey(e)) return;
    bag.replace(e, bag.get(e), bag.get(e) - 1);
    if (bag.get(e) == 0)
      bag.remove(e);
  }

  public int size() {
    Collection <Integer> copy = bag.values();
    int size = 0;
    for (int a : copy) {
      size += a;
    }
    return size;
  }

  public int sizeDistinct() {
    return bag.size();
  }

  public boolean contains(T e) {
    return bag.containsKey(e);
  }

  public int count(T e) {
    return bag.get(e);
  }
}
