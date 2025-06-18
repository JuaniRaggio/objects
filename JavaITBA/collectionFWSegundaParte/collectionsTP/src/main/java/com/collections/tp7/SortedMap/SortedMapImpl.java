package com.collections.tp7.SortedMap;

import java.util.Map;
import java.util.TreeMap;

public class SortedMapImpl<K extends Comparable<K>, V> extends TreeMap<K, V> implements SortedMap<K, V> {
  public V firstValue() {
    return this.get(this.firstKey());
  }

  public java.util.Iterator<Map.Entry<K, V>> iterator() {
    return this.entrySet().iterator();
  }
}
