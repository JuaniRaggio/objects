package com.collections.tp7.MultiMap;

import java.util.Set;

public interface MultiMap <K, V extends Comparable<V>> {
  void put(K key, V value);
  int size();
  int size(K key);
  Set<V> remove(Object key);
  void remove(K key, V value);
  Iterable<V> get(K key);
}
