package com.collections.tp7.IterableBag;

public interface Bag <T> {

  void add(T e);

  void remove(T e);

  int size();

  int sizeDistinct();

  boolean contains(T e);

  int count(T e);

}
